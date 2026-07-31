package com.ewallet.dao;

import com.ewallet.model.Transaction;
import com.ewallet.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    public void add(Transaction t) throws SQLException {
        String sql = "INSERT INTO transactions (account_id, username, type, amount, details, related_user) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, t.getAccountId());
            ps.setString(2, t.getUsername());
            ps.setString(3, t.getType());
            ps.setBigDecimal(4, t.getAmount());
            ps.setString(5, t.getDetails());
            ps.setString(6, t.getRelatedUser());
            ps.executeUpdate();
        }
    }

    public List<Transaction> findByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM transactions WHERE username = ? ORDER BY created_at DESC LIMIT 100";
        List<Transaction> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        }
        return list;
    }

    public List<Transaction> findAll(int limit) throws SQLException {
        String sql = "SELECT * FROM transactions ORDER BY created_at DESC LIMIT ?";
        List<Transaction> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, limit);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        }
        return list;
    }

    private Transaction mapRow(ResultSet rs) throws SQLException {
        Transaction t = new Transaction();
        t.setId(rs.getInt("id"));
        t.setAccountId(rs.getInt("account_id"));
        t.setUsername(rs.getString("username"));
        t.setType(rs.getString("type"));
        t.setAmount(rs.getBigDecimal("amount"));
        t.setDetails(rs.getString("details"));
        t.setRelatedUser(rs.getString("related_user"));
        Timestamp ts = rs.getTimestamp("created_at");
        if (ts != null) t.setCreatedAt(ts.toLocalDateTime());
        return t;
    }
}
