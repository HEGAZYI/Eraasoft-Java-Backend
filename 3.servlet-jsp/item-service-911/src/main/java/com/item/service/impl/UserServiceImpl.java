package com.item.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.item.model.User;
import com.item.service.UserService;
import com.item.util.DbUtil;
import com.item.util.PasswordUtil;

public class UserServiceImpl implements UserService {

    private final DataSource dataSource;

    public UserServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean register(User user) {
        String sql = "INSERT INTO users (username, email, password_hash, full_name) "
                   + "VALUES (?, ?, ?, ?)";
        Connection conn = null;
        System.out.println(sql);
        PreparedStatement ps = null;
        
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPasswordHash());
            ps.setString(4, user.getFullName());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("register error: " + e.getMessage());
            return false;
        } finally {
            DbUtil.closeQuietly(conn, ps, null);
        }
    }

    @Override
    public User login(String usernameOrEmail, String password) {
        String sql = "SELECT id, username, email, password_hash, full_name, created_at "
                   + "FROM users WHERE username = ? OR email = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, usernameOrEmail);
            ps.setString(2, usernameOrEmail);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = mapUser(rs);
                if (PasswordUtil.verify(password, user.getPasswordHash())) {
                    return user;
                }
            }
        } catch (SQLException e) {
            System.err.println("login error: " + e.getMessage());
        } finally {
            DbUtil.closeQuietly(conn, ps, rs);
        }
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return findByColumn("username", username);
    }

    @Override
    public User findByEmail(String email) {
        return findByColumn("email", email);
    }

    @Override
    public User findById(Long id) {
        String sql = "SELECT id, username, email, password_hash, full_name, created_at FROM users WHERE id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return mapUser(rs);
            }
        } catch (SQLException e) {
            System.err.println("findById error: " + e.getMessage());
        } finally {
            DbUtil.closeQuietly(conn, ps, rs);
        }
        return null;
    }

    @Override
    public boolean updatePassword(Long userId, String newPasswordHash) {
        String sql = "UPDATE users SET password_hash = ? WHERE id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, newPasswordHash);
            ps.setLong(2, userId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("updatePassword error: " + e.getMessage());
            return false;
        } finally {
            DbUtil.closeQuietly(conn, ps, null);
        }
    }

    @Override
    public boolean deleteAccount(Long userId) {
        String sql = "DELETE FROM users WHERE id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, userId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("deleteAccount error: " + e.getMessage());
            return false;
        } finally {
            DbUtil.closeQuietly(conn, ps, null);
        }
    }

    private User findByColumn(String column, String value) {
        // column is internal only – never user input
        String sql = "SELECT id, username, email, password_hash, full_name, created_at FROM users WHERE "
                   + column + " = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, value);
            rs = ps.executeQuery();
            if (rs.next()) {
                return mapUser(rs);
            }
        } catch (SQLException e) {
            System.err.println("findByColumn error: " + e.getMessage());
        } finally {
            DbUtil.closeQuietly(conn, ps, rs);
        }
        return null;
    }

    private User mapUser(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getLong("id"));
        u.setUsername(rs.getString("username"));
        u.setEmail(rs.getString("email"));
        u.setPasswordHash(rs.getString("password_hash"));
        u.setFullName(rs.getString("full_name"));
        u.setCreatedAt(rs.getTimestamp("created_at"));
        return u;
    }
}
