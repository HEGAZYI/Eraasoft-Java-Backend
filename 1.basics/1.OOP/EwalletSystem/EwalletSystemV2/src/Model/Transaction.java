package Model;

import java.time.LocalDateTime;

public class Transaction {

    private String username;
    private String type; // DEPOSIT / WITHDRAW / TRANSFER / LOGIN / SIGNUP
    private double amount;
    private String details;
    private LocalDateTime time;

    public Transaction(String username, String type, double amount, String details) {
        this.username = username;
        this.type = type;
        this.amount = amount;
        this.details = details;
        this.time = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return time + " | " + username + " | " + type + " | " + amount + " | " + details;
    }
}