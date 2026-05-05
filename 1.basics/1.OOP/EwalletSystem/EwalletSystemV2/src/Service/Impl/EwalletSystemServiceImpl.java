package Service.Impl;

import Model.Account;
import Model.EwalletSystem;
import Model.Transaction;
import Service.AccountService;
import Service.EwalletSystemService;
import Service.Validation;

import java.util.Scanner;

public class EwalletSystemServiceImpl implements EwalletSystemService {

    private AccountService accountService = new AccountServiceImpl();

    EwalletSystem system = new EwalletSystem();

    private final Scanner scanner = new Scanner(System.in);


    @Override
    public void start() {

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║        💳  E-WALLET SYSTEM           ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║   Secure • Fast • Easy Payments      ║");
        System.out.println("╚══════════════════════════════════════╝");

        int invalidCounter = 0;
        boolean exit = false;

        while (true) {

            System.out.println("\n╔════════════ MENU ════════════╗");
            System.out.println("║ [1] 🔐 Login                ║");
            System.out.println("║ [2] 📝 Sign Up              ║");
            System.out.println("║ [3] 🚪 Exit                 ║");
            System.out.println("╚═════════════════════════════╝");
            System.out.print("👉 Enter your choice: ");

            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("\n🔄 Redirecting to Login...");
                    login();
                    break;

                case 2:
                    System.out.println("\n🔄 Redirecting to Sign Up...");
                    signup();
                    break;

                case 3:
                    System.out.println("\n══════════════════════════════");
                    System.out.println("🙏 Thank you for using E-Wallet");
                    System.out.println("👋 Goodbye!");
                    System.out.println("══════════════════════════════");
                    exit = true;
                    break;

                default:
                    System.out.println("\n❌ Invalid choice! Please try again.");
                    invalidCounter++;
            }

            if (exit) {
                break;
            }

            if (invalidCounter == 4) {
                System.out.println("\n🚫 Too many invalid attempts!");
                System.out.println("📞 Please contact support.");
                break;
            }
        }
    }

    // to check on current user
    private Account currentUser;

    private void signup() {
        Validation validation = new ValidationImpl();

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║           📝 CREATE ACCOUNT          ║");
        System.out.println("╚══════════════════════════════════════╝");

        System.out.print("👤 Enter Username   : ");
        String userName = scanner.next();

        System.out.print("🔒 Enter Password   : ");
        String password = scanner.next();

        System.out.print("📱 Enter Phone No.  : ");
        String phoneNumber = scanner.next();

        System.out.print("🎂 Enter Age        : ");
        int age = scanner.nextInt();

        String usernameError = validation.validateUsername(userName);
        if (usernameError != null) {
            System.out.println("❌ " + usernameError);
            return;
        }

        String passwordError = validation.validatePassword(password);
        if (passwordError != null) {
            System.out.println("❌ " + passwordError);
            return;
        }

        String ageError = validation.validateAge(age);
        if (ageError != null) {
            System.out.println("❌ " + ageError);
            return;
        }

        String phoneError = validation.validatePhone(phoneNumber);
        if (phoneError != null) {
            System.out.println("❌ " + phoneError);
            return;
        }

        System.out.println("\n⏳ Creating your account...");

        Account account = new Account(userName, password, phoneNumber, age);

        boolean isAccountCreated = accountService.createAccount(account);

        if (isAccountCreated) {
            currentUser = system.getAccounts().get(userName); //session created

            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║   ✅ Account Created Successfully!   ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║   🎉 Welcome, " + userName + "!         ");
            System.out.println("╚══════════════════════════════════════╝");

            mainProfile();

        } else {
            System.out.println("❌ Something went wrong!");
        }
    }


    private void login() {

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║             🔐 LOGIN                ║");
        System.out.println("╚══════════════════════════════════════╝");

        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        while (attempts < MAX_ATTEMPTS) {

            System.out.print("👤 Enter Username : ");
            String username = scanner.next();

            System.out.print("🔒 Enter Password : ");
            String password = scanner.next();

            // Empty validation
            if (username.isEmpty() || password.isEmpty()) {
                System.out.println("❌ Username and password cannot be empty!");
                continue;
            }

            Account account = new Account(username, password);

            // Check if user exists
            if (!accountService.isAccountExistByUserNameAndPassword(account)) {
                System.out.println("❌ User does not exist!");
                attempts++;
                continue;
            }

            if (!account.isActive()) {
                System.out.println("❌ Account is inactive!");
                return;
            }

            currentUser = system.getAccount(username);

            system.getTransactionService().add(
                    new Transaction(username, "LOGIN", 0, "User logged in")
            );

            boolean isAccountExist =
                accountService.isAccountExistByUserNameAndPassword(account);

            if (isAccountExist) {
                System.out.println("\n╔══════════════════════════════════════╗");
                System.out.println("║        ✅ LOGIN SUCCESSFUL          ║");
                System.out.println("╠══════════════════════════════════════╣");
                System.out.println("║   👋 Welcome back, " + username + "!     ");
                System.out.println("╚══════════════════════════════════════╝");

                mainProfile();

            } else {
                System.out.println("\n╔══════════════════════════════════════╗");
                System.out.println("║            ❌ LOGIN FAILED          ║");
                System.out.println("╠══════════════════════════════════════╣");
                System.out.println("║ Invalid username or password!       ║");
                System.out.println("╚══════════════════════════════════════╝");
            }
        }

        System.out.println("\n🚫 Too many failed attempts. Try again later.");
    }

    private void mainProfile() {

        int choice;

        do {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║          💼 MAIN MENU               ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║ [1] 💰 Deposit                     ║");
            System.out.println("║ [2] 💸 Withdraw                    ║");
            System.out.println("║ [3] 🔄 Transfer                    ║");
            System.out.println("║ [4] 📄 Account Details             ║");
            System.out.println("║ [5] 🔑 Change Password             ║");
            System.out.println("║ [6] 🚪 Logout                      ║");
            System.out.println("╚══════════════════════════════════════╝");

            System.out.print("👉 Choose: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> deposit();
                case 2 -> withdraw();
                case 3 -> transfer();
                case 4 -> showDetails();
                case 5 -> changePassword();
                case 6 -> logout();
                default -> System.out.println("❌ Invalid choice!");
            }

        } while (currentUser != null); // 🔥 loop until logout
    }

    // deposit service -> phase 4
    private void deposit() {

        if (currentUser == null) {
            System.out.println("No user logged in!");
            return;
        }

        System.out.print("💰 Enter amount: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("❌ Amount must be greater than 0!");
            return;
        }

        // sync from system (safe design)
        Account account = system.getAccounts().get(currentUser.getUsername());

        account.setBalance(account.getBalance() + amount);

        System.out.println("✅ Deposit successful!");
        System.out.println("💳 New Balance: " + account.getBalance());

        system.getTransactionService().add(
                new Transaction(currentUser.getUsername(), "DEPOSIT", amount, "Deposit money")
        );
    }

    // withdraw service -> phase 5
    private void withdraw() {

        if (currentUser == null) {
            System.out.println("No user logged in!");
            return;
        }

        System.out.print("💸 Enter amount: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("❌ Amount must be greater than 0!");
            return;
        }

        Account account = system.getAccounts().get(currentUser.getUsername());

        if (account.getBalance() < amount) {
            System.out.println("❌ Insufficient balance!");
            return;
        }

        account.setBalance(account.getBalance() - amount);

        System.out.println("✅ Withdraw successful!");
        System.out.println("💳 New Balance: " + account.getBalance());

        system.getTransactionService().add(
                new Transaction(currentUser.getUsername(), "WITHDRAW", amount, "Withdraw money")
        );
    }

    // transfer service -> phase 6
    public void transfer() {

        System.out.print("Enter receiver username: ");
        String receiverUsername = scanner.next();

        if (receiverUsername.equals(currentUser.getUsername())) {
            System.out.println("❌ You cannot transfer to yourself!");
            return;
        }

        Account sender = system.getAccounts().get(currentUser.getUsername());
        Account receiver = system.getAccounts().get(receiverUsername);

        if (receiver == null) {
            System.out.println("❌ Receiver not found!");
            return;
        }

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("❌ Amount must be greater than 0!");
            return;
        }

        if (sender.getBalance() < amount) {
            System.out.println("❌ Insufficient balance!");
            return;
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        System.out.println("✅ Transfer successful!");
        System.out.println("💳 Your Balance: " + sender.getBalance());

        system.getTransactionService().add(
                new Transaction(sender.getUsername(), "TRANSFER", amount, "To " + receiverUsername)
        );
    }

    // change password -> phase 7
    public void changePassword() {

        Account account = system.getAccounts().get(currentUser.getUsername());

        System.out.print("Enter current password: ");
        String oldPassword = scanner.next();

        if (!account.getPassword().equals(oldPassword)) {
            System.out.println("❌ Incorrect password!");
            return;
        }

        System.out.print("Enter new password: ");
        String newPassword = scanner.next();

        if (newPassword.equals(oldPassword)) {
            System.out.println("❌ New password cannot be same as old password!");
            return;
        }

        if (newPassword.isBlank() || newPassword.length() < 4) {
            System.out.println("❌ Weak password!");
            return;
        }

        account.setPassword(newPassword);

        System.out.println("✅ Password changed successfully!");
    }

    // show data -> phase 8
    public void showDetails() {

        Account account = system.getAccounts().get(currentUser.getUsername());

        System.out.println("========== ACCOUNT INFO ==========");
        System.out.println("Username: " + account.getUsername());
        System.out.println("Phone: " + account.getPhoneNumber());
        System.out.println("Age: " + account.getAge());
        System.out.println("Balance: " + account.getBalance());
    }

    // logout -> phase 9
    public void logout() {

        if (currentUser == null) {
            System.out.println("No user is currently logged in!");
            return;
        }

        System.out.println("Logging out " + currentUser.getUsername() + "...");

        currentUser = null;

        System.out.println("Logged out successfully!");
    }
}