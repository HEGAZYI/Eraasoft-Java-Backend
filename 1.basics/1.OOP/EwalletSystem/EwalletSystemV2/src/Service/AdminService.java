package Service;

import Model.Account;
import Model.EwalletSystem;

public class AdminService {

    private final EwalletSystem system;

    public AdminService(EwalletSystem system) {
        this.system = system;
    }

    public void showAllAccounts() {

        System.out.println("===== ALL ACCOUNTS =====");

        for (Account acc : system.getAccounts().values()) {
            System.out.println(
                    acc.getUsername() +
                            " | Admin: " + acc.isAdmin() +
                            " | Active: " + acc.isActive() +
                            " | Balance: " + acc.getBalance()
            );
        }
    }

    public void deactivateAccount(String username) {

        Account acc = system.getAccount(username);

        if (acc == null) {
            System.out.println("User not found!");
            return;
        }

        acc.setActive(false);
        System.out.println("Account deactivated!");
    }

    public void deleteAccount(String username) {
        system.deleteAccount(username);
        System.out.println("Account deleted!");
    }
}