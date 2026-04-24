package Service.Impl;

import Model.Account;
import Service.AccountService;
import Service.EwalletSystemService;

import java.util.Scanner;

public class EwalletSystemServiceImpl implements EwalletSystemService {

    private AccountService accountService = new AccountServiceImpl();

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


    private void signup() {

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
        float age = scanner.nextFloat();

        System.out.println("\n⏳ Creating your account...");

        // Create account object
        Account account = new Account(userName, password, phoneNumber, age);

        // Call service layer
        boolean isAccountCreated = accountService.createAccount(account);

        if (isAccountCreated) {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║   ✅ Account Created Successfully!   ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║   🎉 Welcome, " + userName + "!         ");
            System.out.println("╚══════════════════════════════════════╝");

            mainProfile();

        } else {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║        ❌ SIGNUP FAILED              ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║ Username already exists! Try again. ║");
            System.out.println("╚══════════════════════════════════════╝");
        }
    }


    private void login() {

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║             🔐 LOGIN                ║");
        System.out.println("╚══════════════════════════════════════╝");

        System.out.print("👤 Enter Username : ");
        String userName = scanner.next();

        System.out.print("🔒 Enter Password : ");
        String password = scanner.next();

        System.out.println("\n⏳ Verifying credentials...");

        Account account = new Account(userName, password);

        boolean isAccountExist =
                accountService.isAccountExistByUserNameAndPassword(account);

        if (isAccountExist) {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║        ✅ LOGIN SUCCESSFUL          ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║   👋 Welcome back, " + userName + "!     ");
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

    private void mainProfile() {

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║          💼 MAIN DASHBOARD           ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ [1] 💰 Deposit                      ║");
        System.out.println("║ [2] 💸 Withdraw                     ║");
        System.out.println("║ [3] 📊 Check Balance                ║");
        System.out.println("║ [4] 🚪 Logout                       ║");
        System.out.println("╚══════════════════════════════════════╝");
    }
}