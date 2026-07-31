package com.ewallet.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private int id;
    private int accountId;
    private String username;
    private String type;
    private BigDecimal amount;
    private String details;
    private String relatedUser;
    private LocalDateTime createdAt;

    public Transaction() {}

    public Transaction(int accountId, String username, String type, BigDecimal amount, String details) {
        this.accountId = accountId;
        this.username = username;
        this.type = type;
        this.amount = amount;
        this.details = details;
    }

    public Transaction(int accountId, String username, String type, BigDecimal amount, String details, String relatedUser) {
        this(accountId, username, type, amount, details);
        this.relatedUser = relatedUser;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public String getRelatedUser() { return relatedUser; }
    public void setRelatedUser(String relatedUser) { this.relatedUser = relatedUser; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
