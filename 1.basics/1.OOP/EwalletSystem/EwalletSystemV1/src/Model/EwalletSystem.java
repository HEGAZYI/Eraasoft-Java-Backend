package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EwalletSystem {

    private final String name = "My Electronic wallet";

    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    public String getName() {
        return name;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public boolean registerAccount(Account account) {
        return accounts.putIfAbsent(account.getUsername(), account) == null;
    }

    public boolean validateCredentials(String username, String password) {
        Account account = accounts.get(username);

        // If account is null, it doesn't exist. Otherwise, check the password.
        return account != null && account.getPassword().equals(password);
    }
}