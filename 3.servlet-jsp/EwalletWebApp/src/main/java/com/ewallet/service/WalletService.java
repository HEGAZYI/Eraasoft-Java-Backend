package com.ewallet.service;

import com.ewallet.dao.AccountDAO;
import com.ewallet.dao.TransactionDAO;
import com.ewallet.model.Account;
import com.ewallet.model.Transaction;
import com.ewallet.util.ValidationUtil;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class WalletService {

    private final AccountDAO accountDAO = new AccountDAO();
    private final TransactionDAO transactionDAO = new TransactionDAO();

    public static class Result {
        public final boolean success;
        public final String message;
        public final BigDecimal newBalance;

        public Result(boolean success, String message) {
            this(success, message, null);
        }
        public Result(boolean success, String message, BigDecimal newBalance) {
            this.success = success;
            this.message = message;
            this.newBalance = newBalance;
        }
    }

    public Result deposit(int accountId, String username, String amountStr) {
        String err = ValidationUtil.validateAmount(amountStr);
        if (err != null) return new Result(false, err);

        BigDecimal amount = new BigDecimal(amountStr);

        try {
            Optional<Account> opt = accountDAO.findById(accountId);
            if (opt.isEmpty()) return new Result(false, "Account not found");

            Account account = opt.get();
            BigDecimal newBalance = account.getBalance().add(amount);

            if (!accountDAO.updateBalance(accountId, newBalance)) {
                return new Result(false, "Deposit failed");
            }

            transactionDAO.add(new Transaction(
                    accountId, username, "DEPOSIT", amount, "Deposit money"));

            return new Result(true, "Deposit successful!", newBalance);

        } catch (SQLException e) {
            e.printStackTrace();
            return new Result(false, "Database error");
        }
    }

    public Result withdraw(int accountId, String username, String amountStr) {
        String err = ValidationUtil.validateAmount(amountStr);
        if (err != null) return new Result(false, err);

        BigDecimal amount = new BigDecimal(amountStr);

        try {
            Optional<Account> opt = accountDAO.findById(accountId);
            if (opt.isEmpty()) return new Result(false, "Account not found");

            Account account = opt.get();
            if (account.getBalance().compareTo(amount) < 0) {
                return new Result(false, "Insufficient balance");
            }

            BigDecimal newBalance = account.getBalance().subtract(amount);
            if (!accountDAO.updateBalance(accountId, newBalance)) {
                return new Result(false, "Withdraw failed");
            }

            transactionDAO.add(new Transaction(
                    accountId, username, "WITHDRAW", amount, "Withdraw money"));

            return new Result(true, "Withdrawal successful!", newBalance);

        } catch (SQLException e) {
            e.printStackTrace();
            return new Result(false, "Database error");
        }
    }

    public Result transfer(int senderId, String senderUsername, String receiverUsername, String amountStr) {
        if (receiverUsername == null || receiverUsername.isBlank()) {
            return new Result(false, "Receiver username is required");
        }
        if (receiverUsername.equalsIgnoreCase(senderUsername)) {
            return new Result(false, "You cannot transfer to yourself");
        }

        String err = ValidationUtil.validateAmount(amountStr);
        if (err != null) return new Result(false, err);

        BigDecimal amount = new BigDecimal(amountStr);

        try {
            Optional<Account> receiverOpt = accountDAO.findByUsername(receiverUsername.trim());
            if (receiverOpt.isEmpty()) {
                return new Result(false, "Receiver not found");
            }
            Account receiver = receiverOpt.get();
            if (!receiver.isActive()) {
                return new Result(false, "Receiver account is inactive");
            }

            Optional<Account> senderOpt = accountDAO.findById(senderId);
            if (senderOpt.isEmpty()) return new Result(false, "Sender account not found");

            if (senderOpt.get().getBalance().compareTo(amount) < 0) {
                return new Result(false, "Insufficient balance");
            }

            boolean ok = accountDAO.transfer(senderId, receiver.getId(), amount);
            if (!ok) {
                return new Result(false, "Transfer failed (insufficient funds or error)");
            }

            // Log for both sides
            transactionDAO.add(new Transaction(
                    senderId, senderUsername, "TRANSFER", amount,
                    "To " + receiverUsername, receiverUsername));

            transactionDAO.add(new Transaction(
                    receiver.getId(), receiverUsername, "TRANSFER", amount,
                    "From " + senderUsername, senderUsername));

            BigDecimal newBalance = senderOpt.get().getBalance().subtract(amount);
            return new Result(true, "Transfer successful!", newBalance);

        } catch (SQLException e) {
            e.printStackTrace();
            return new Result(false, "Database error");
        }
    }

    public Optional<Account> getAccount(int id) {
        try {
            return accountDAO.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public List<Transaction> getHistory(String username) {
        try {
            return transactionDAO.findByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    // ---- Admin operations ----

    public List<Account> getAllAccounts() {
        try {
            return accountDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public Result deactivate(int accountId) {
        try {
            if (accountDAO.setActive(accountId, false)) {
                return new Result(true, "Account deactivated");
            }
            return new Result(false, "Account not found");
        } catch (SQLException e) {
            return new Result(false, "Database error");
        }
    }

    public Result activate(int accountId) {
        try {
            if (accountDAO.setActive(accountId, true)) {
                return new Result(true, "Account activated");
            }
            return new Result(false, "Account not found");
        } catch (SQLException e) {
            return new Result(false, "Database error");
        }
    }

    public Result deleteAccount(int accountId) {
        try {
            if (accountDAO.delete(accountId)) {
                return new Result(true, "Account deleted");
            }
            return new Result(false, "Account not found");
        } catch (SQLException e) {
            return new Result(false, "Database error");
        }
    }
}
