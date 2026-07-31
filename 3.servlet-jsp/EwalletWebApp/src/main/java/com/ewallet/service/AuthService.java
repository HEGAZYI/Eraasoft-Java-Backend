package com.ewallet.service;

import com.ewallet.dao.AccountDAO;
import com.ewallet.dao.TransactionDAO;
import com.ewallet.model.Account;
import com.ewallet.model.Transaction;
import com.ewallet.util.PasswordUtil;
import com.ewallet.util.ValidationUtil;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Optional;

public class AuthService {

    private final AccountDAO accountDAO = new AccountDAO();
    private final TransactionDAO transactionDAO = new TransactionDAO();

    public static class Result {
        public final boolean success;
        public final String message;
        public final Account account;

        public Result(boolean success, String message) {
            this(success, message, null);
        }
        public Result(boolean success, String message, Account account) {
            this.success = success;
            this.message = message;
            this.account = account;
        }
    }

    public Result register(String username, String password, String phone, int age) {
        // Validate
        String err;
        if ((err = ValidationUtil.validateUsername(username)) != null) return new Result(false, err);
        if ((err = ValidationUtil.validatePassword(password)) != null) return new Result(false, err);
        if ((err = ValidationUtil.validatePhone(phone)) != null) return new Result(false, err);
        if ((err = ValidationUtil.validateAge(age)) != null) return new Result(false, err);

        try {
            if (accountDAO.usernameExists(username)) {
                return new Result(false, "Username already taken");
            }
            if (accountDAO.phoneExists(phone)) {
                return new Result(false, "Phone number already registered");
            }

            String hash = PasswordUtil.hash(password);
            Account account = new Account(username, hash, phone, age);

            if (!accountDAO.create(account)) {
                return new Result(false, "Could not create account. Please try again.");
            }

            // Log signup transaction
            transactionDAO.add(new Transaction(
                    account.getId(), username, "SIGNUP", BigDecimal.ZERO, "Account created"));

            return new Result(true, "Account created successfully!", account);

        } catch (SQLException e) {
            e.printStackTrace();
            return new Result(false, "Database error. Please try again later.");
        }
    }

    public Result login(String username, String password) {
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            return new Result(false, "Username and password are required");
        }

        try {
            Optional<Account> opt = accountDAO.findByUsername(username.trim());
            if (opt.isEmpty()) {
                return new Result(false, "Invalid username or password");
            }

            Account account = opt.get();

            if (!account.isActive()) {
                return new Result(false, "Your account has been deactivated. Contact support.");
            }

            if (!PasswordUtil.verify(password, account.getPasswordHash())) {
                return new Result(false, "Invalid username or password");
            }

            // Log login
            transactionDAO.add(new Transaction(
                    account.getId(), account.getUsername(), "LOGIN", BigDecimal.ZERO, "User logged in"));

            // Never expose password hash to session
            account.setPasswordHash(null);

            return new Result(true, "Login successful", account);

        } catch (SQLException e) {
            e.printStackTrace();
            return new Result(false, "Database error. Please try again later.");
        }
    }

    public Result changePassword(int accountId, String currentPassword, String newPassword) {
        String err = ValidationUtil.validatePassword(newPassword);
        if (err != null) return new Result(false, err);

        if (newPassword.equals(currentPassword)) {
            return new Result(false, "New password cannot be the same as the current password");
        }

        try {
            Optional<Account> opt = accountDAO.findById(accountId);
            if (opt.isEmpty()) return new Result(false, "Account not found");

            Account account = opt.get();
            if (!PasswordUtil.verify(currentPassword, account.getPasswordHash())) {
                return new Result(false, "Current password is incorrect");
            }

            String newHash = PasswordUtil.hash(newPassword);
            if (!accountDAO.updatePassword(accountId, newHash)) {
                return new Result(false, "Could not update password");
            }

            transactionDAO.add(new Transaction(
                    accountId, account.getUsername(), "PASSWORD_CHANGE",
                    BigDecimal.ZERO, "Password changed"));

            return new Result(true, "Password changed successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            return new Result(false, "Database error. Please try again later.");
        }
    }
}
