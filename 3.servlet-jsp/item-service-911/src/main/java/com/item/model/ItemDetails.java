package com.item.model;

import java.sql.Timestamp;

public class ItemDetails {
    private Long id;
    private Long itemId;
    private String description;
    private String category;
    private String manufacturer;
    private int warrantyMonths;
    private Timestamp createdAt;

    public ItemDetails() {
    }

    public ItemDetails(Long itemId, String description, String category, String manufacturer, int warrantyMonths) {
        this.itemId = itemId;
        this.description = description;
        this.category = category;
        this.manufacturer = manufacturer;
        this.warrantyMonths = warrantyMonths;
    }

    public ItemDetails(Long id, Long itemId, String description, String category,
                       String manufacturer, int warrantyMonths, Timestamp createdAt) {
        this.id = id;
        this.itemId = itemId;
        this.description = description;
        this.category = category;
        this.manufacturer = manufacturer;
        this.warrantyMonths = warrantyMonths;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
