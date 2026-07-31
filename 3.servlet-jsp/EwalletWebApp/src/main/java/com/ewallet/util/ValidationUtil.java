package com.ewallet.util;

import java.util.regex.Pattern;

/**
 * Server-side input validation (mirrors original ValidationImpl + extra safety).
 */
public final class ValidationUtil {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Z][A-Za-z0-9_]{2,49}$");
    private static final Pattern PHONE_PATTERN    = Pattern.compile("^01\\d{9}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$");

    private ValidationUtil() {}

    public static String validateUsername(String username) {
        if (username == null || username.isBlank()) {
            return "Username is required";
        }
        username = username.trim();
        if (username.length() < 3) {
            return "Username must be at least 3 characters";
        }
        if (!Character.isUpperCase(username.charAt(0))) {
            return "Username must start with an uppercase letter";
        }
        if (!USERNAME_PATTERN.matcher(username).matches()) {
            return "Username may only contain letters, digits and underscore";
        }
        return null;
    }

    public static String validatePassword(String password) {
        if (password == null || password.isBlank()) {
            return "Password is required";
        }
        if (password.length() < 6) {
            return "Password must be at least 6 characters";
        }
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            return "Password must contain upper, lower case letters and a digit";
        }
        return null;
    }

    public static String validateAge(int age) {
        if (age < 18) {
            return "You must be 18 or older to register";
        }
        if (age > 120) {
            return "Invalid age";
        }
        return null;
    }

    public static String validatePhone(String phone) {
        if (phone == null || phone.isBlank()) {
            return "Phone number is required";
        }
        if (!PHONE_PATTERN.matcher(phone.trim()).matches()) {
            return "Phone must be Egyptian format (11 digits starting with 01)";
        }
        return null;
    }

    public static String validateAmount(String amountStr) {
        if (amountStr == null || amountStr.isBlank()) {
            return "Amount is required";
        }
        try {
            double amount = Double.parseDouble(amountStr);
            if (amount <= 0) {
                return "Amount must be greater than zero";
            }
            if (amount > 1_000_000) {
                return "Amount exceeds maximum limit";
            }
            return null;
        } catch (NumberFormatException e) {
            return "Invalid amount format";
        }
    }
}
