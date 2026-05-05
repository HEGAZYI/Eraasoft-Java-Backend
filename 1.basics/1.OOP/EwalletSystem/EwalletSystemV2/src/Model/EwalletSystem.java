package Model;

import Service.Impl.TransactionImpl;
import Service.TransactionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EwalletSystem {

    private final String name = "My Electronic wallet";

    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    private final TransactionService transactionService = new TransactionImpl();

    public EwalletSystem() {

        // AUTO ADMIN CREATION
        Account admin = new Account("IAM", "IAM123", true);
        accounts.put(admin.getUsername(), admin);
    }

    public String getName() {
        return name;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public Account getAccount(String username) {
        return accounts.get(username);
    }


    public void deleteAccount(String username) {
        accounts.remove(username);
    }

    public TransactionService getTransactionService() {
        return transactionService;
    }

    public boolean registerAccount(Account account) {
        if (accounts.containsKey(account.getUsername())) return false;

        accounts.put(account.getUsername(), account);

        transactionService.add(
                new Transaction(account.getUsername(), "SIGNUP", 0, "Account created")
        );

        return true;
    }

    public boolean validateCredentials(String username, String password) {
        Account account = accounts.get(username);

        // If account is null, it doesn't exist. Otherwise, check the password.
        return account != null && account.getPassword().equals(password);
    }

    public boolean isUsernameExists(String username) {
        return accounts.containsKey(username);
    }

    public boolean isPhoneExists(String phone) {
        for (Account acc : accounts.values()) {
            if (acc.getPhoneNumber().equals(phone)) {
                return true;
            }
        }
        return false;
    }
}