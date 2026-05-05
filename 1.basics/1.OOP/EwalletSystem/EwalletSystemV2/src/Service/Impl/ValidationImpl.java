package Service.Impl;

import Service.Validation;

import Model.Account;
import java.util.Map;

    public class ValidationImpl implements Validation  {

    // Username Validation
    public String validateUsername(String username) {
        if (username == null || username.length() < 3) {
            return "Username must be at least 3 characters";
        }

        if (!Character.isUpperCase(username.charAt(0))) {
            return "Username must start with uppercase letter";
        }

        return null;
    }

    // Password Validation
    public String validatePassword(String password) {
        if (password == null || password.length() < 6) {
            return "Password must be at least 6 characters";
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
            if (Character.isDigit(c)) hasDigit = true;
        }

        if (!hasUpper || !hasLower || !hasDigit) {
            return "Password must contain upper, lower, and digit";
        }

        return null;
    }

    // Age Validation
    public String validateAge(int age) {
        if (age < 18) {
            return "Age must be 18 or older";
        }
        return null;
    }

    // Phone Validation (Egypt)
    public String validatePhone(String phone) {
        if (phone == null || !phone.matches("^01\\d{9}$")) {
            return "Phone must be Egyptian format (11 digits starting with 01)";
        }

        return null;
    }
}