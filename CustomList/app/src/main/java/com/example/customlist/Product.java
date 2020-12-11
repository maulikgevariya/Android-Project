package com.example.customlist;

public class Product {
    private String title;
    private String description;
    private String type;
    private String price;
    private boolean sale;

    public Product(String title, String description, String type, String price, boolean sale) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.price = price;
        this.sale = sale;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    public boolean isSale() {
        return sale;
    }
}
