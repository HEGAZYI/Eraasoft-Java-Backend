package com.item.model;

import java.sql.Timestamp;

public class Item {
    private Long id;
    private String name;
    private double price;
    private int totalNumber;
    private Long userId;
    private Timestamp createdAt;
    private ItemDetails details; // optional one-to-one

    public Item() {
    }

    public Item(String name, double price, int totalNumber) {
        this.name = name;
        this.price = price;
        this.totalNumber = totalNumber;
    }

    public Item(Long id, String name, double price, int totalNumber) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalNumber = totalNumber;
    }

    public Item(Long id, String name, double price, int totalNumber, Long userId, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalNumber = totalNumber;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public ItemDetails getDetails() {
        return details;
    }

    public void setDetails(ItemDetails details) {
        this.details = details;
    }

    public boolean hasDetails() {
        return details != null && details.getId() != null;
    }
}
