package model;

import java.util.Date;

public class Expense {
    private int id;
    private int userId;
    private String category;
    private double amount;
    private Date dateSpent;

    public Expense(int id, int userId, String category, double amount, Date dateSpent) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.amount = amount;
        this.dateSpent = dateSpent;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateSpent() {
        return dateSpent;
    }

    public void setDateSpent(Date dateSpent) {
        this.dateSpent = dateSpent;
    }
}
