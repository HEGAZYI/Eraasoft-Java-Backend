package com.item.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.item.model.Item;
import com.item.model.ItemDetails;
import com.item.service.ItemService;
import com.item.util.DbUtil;

public class ItemServiceImpl implements ItemService {

    private final DataSource dataSource;

    public ItemServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean addItem(Item item) {
        String sql = "INSERT INTO item (name, price, total_number, user_id) "
                   + "VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setDouble(2, item.getPrice());
            ps.setInt(3, item.getTotalNumber());
            if (item.getUserId() != null) {
                ps.setLong(4, item.getUserId());
            } else {
                ps.setNull(4, java.sql.Types.BIGINT);
            }
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("addItem error: " + e.getMessage());
            return false;
        } finally {
            DbUtil.closeQuietly(conn, ps, null);
        }
    }

    @Override
    public boolean updateItem(Item item) {
        String sql = "UPDATE item SET name = ?, price = ?, total_number = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setDouble(2, item.getPrice());
            ps.setInt(3, item.getTotalNumber());
            ps.setLong(4, item.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("updateItem error: " + e.getMessage());
            return false;
        } finally {
            DbUtil.closeQuietly(conn, ps, null);
        }
    }

    @Override
    public Item getItemById(Long id) {
        String sql = "SELECT id, name, price, total_number, user_id, created_at FROM item WHERE id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Item item = mapItem(rs);
                item.setDetails(getItemDetailsByItemId(id));
                return item;
            }
        } catch (SQLException e) {
            System.err.println("getItemById error: " + e.getMessage());
        } finally {
            DbUtil.closeQuietly(conn, ps, rs);
        }
        return null;
    }

    @Override
    public List<Item> getItems() {
        String sql = "SELECT id, name, price, total_number, user_id, created_at FROM item ORDER BY id";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Item> items = new ArrayList<>();
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Item item = mapItem(rs);
                item.setDetails(getItemDetailsByItemId(item.getId()));
                items.add(item);
            }
        } catch (SQLException e) {
            System.err.println("getItems error: " + e.getMessage());
        } finally {
            DbUtil.closeQuietly(conn, ps, rs);
        }
        return items;
    }

    @Override
    public boolean removeItemById(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            removeItemDetailsByItemId(id);
            String sql = "DELETE FROM item WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            int rows = ps.executeUpdate();
            conn.commit();
            return rows > 0;
        } catch (SQLException e) {
            System.err.println("removeItemById error: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ignored) {}
            return false;
        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true);
            } catch (SQLException ignored) {}
            DbUtil.closeQuietly(conn, ps, null);
        }
    }

    @Override
    public boolean addItemDetails(ItemDetails details) {
        String sql = "INSERT INTO item_details (item_id, description, category, manufacturer, warranty_months) "
                   + "VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, details.getItemId());
            ps.setString(2, details.getDescription());
            ps.setString(3, details.getCategory());
            ps.setString(4, details.getManufacturer());
            ps.setInt(5, details.getWarrantyMonths());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("addItemDetails error: " + e.getMessage());
            return false;
        } finally {
            DbUtil.closeQuietly(conn, ps, null);
        }
    }

    @Override
    public boolean updateItemDetails(ItemDetails details) {
        String sql = "UPDATE item_details SET description = ?, category = ?, manufacturer = ?, "
                   + "warranty_months = ? WHERE item_id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, details.getDescription());
            ps.setString(2, details.getCategory());
            ps.setString(3, details.getManufacturer());
            ps.setInt(4, details.getWarrantyMonths());
            ps.setLong(5, details.getItemId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("updateItemDetails error: " + e.getMessage());
            return false;
        } finally {
            DbUtil.closeQuietly(conn, ps, null);
        }
    }

    @Override
    public ItemDetails getItemDetailsByItemId(Long itemId) {
        String sql = "SELECT id, item_id, description, category, manufacturer, warranty_months, created_at "
                   + "FROM item_details WHERE item_id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, itemId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return mapDetails(rs);
            }
        } catch (SQLException e) {
            System.err.println("getItemDetailsByItemId error: " + e.getMessage());
        } finally {
            DbUtil.closeQuietly(conn, ps, rs);
        }
        return null;
    }

    @Override
    public boolean removeItemDetailsByItemId(Long itemId) {
        String sql = "DELETE FROM item_details WHERE item_id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, itemId);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("removeItemDetailsByItemId error: " + e.getMessage());
            return false;
        } finally {
            DbUtil.closeQuietly(conn, ps, null);
        }
    }

    private Item mapItem(ResultSet rs) throws SQLException {
        Item item = new Item();
        item.setId(rs.getLong("id"));
        item.setName(rs.getString("name"));
        item.setPrice(rs.getDouble("price"));
        item.setTotalNumber(rs.getInt("total_number"));
        long uid = rs.getLong("user_id");
        if (!rs.wasNull()) {
            item.setUserId(uid);
        }
        item.setCreatedAt(rs.getTimestamp("created_at"));
        return item;
    }

    private ItemDetails mapDetails(ResultSet rs) throws SQLException {
        ItemDetails d = new ItemDetails();
        d.setId(rs.getLong("id"));
        d.setItemId(rs.getLong("item_id"));
        d.setDescription(rs.getString("description"));
        d.setCategory(rs.getString("category"));
        d.setManufacturer(rs.getString("manufacturer"));
        d.setWarrantyMonths(rs.getInt("warranty_months"));
        d.setCreatedAt(rs.getTimestamp("created_at"));
        return d;
    }
}
