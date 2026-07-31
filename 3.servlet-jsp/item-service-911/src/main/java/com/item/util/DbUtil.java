package com.item.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

/**
 * Centralized JDBC resource cleanup to eliminate duplication.
 */
public final class DbUtil {

    private DbUtil() {
    }

    public static void closeQuietly(AutoCloseable... resources) {
        for (AutoCloseable r : resources) {
            if (Objects.nonNull(r)) {
                try {
                    r.close();
                } catch (Exception ignored) {
                    // swallow
                }
            }
        }
    }

    public static void closeQuietly(Connection conn, Statement stmt, ResultSet rs) {
        closeQuietly(rs, stmt, conn);
    }

    public static void closeQuietly(Connection conn, PreparedStatement ps, ResultSet rs) {
        closeQuietly(rs, ps, conn);
    }
}
