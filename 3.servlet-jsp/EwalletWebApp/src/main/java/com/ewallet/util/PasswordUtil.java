package com.ewallet.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Secure password hashing & verification using BCrypt.
 */
public final class PasswordUtil {

    private static final int WORKLOAD = 12; // recommended cost factor

    private PasswordUtil() {}

    /**
     * Hash a plain-text password with a random salt.
     */
    public static String hash(String plainPassword) {
        if (plainPassword == null || plainPassword.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(WORKLOAD));
    }

    /**
     * Verify a plain-text password against a stored BCrypt hash.
     */
    public static boolean verify(String plainPassword, String storedHash) {
        if (plainPassword == null || storedHash == null) {
            return false;
        }
        try {
            return BCrypt.checkpw(plainPassword, storedHash);
        } catch (Exception e) {
            return false;
        }
    }
}
