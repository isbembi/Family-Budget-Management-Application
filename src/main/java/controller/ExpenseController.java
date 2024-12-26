package controller;

import model.Expense;
import utils.DataBaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseController {
    public static void addExpense(int userId, String category, double amount, Date dateSpent) {
        String query = "INSERT INTO expenses (userId, category, amount, dateSpent) VALUES (?, ?, ?, ?)";
        try (Connection conn = DataBaseUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setString(2, category);
            stmt.setDouble(3, amount);
            stmt.setDate(4, new java.sql.Date(dateSpent.getTime()));
            stmt.executeUpdate();
            System.out.println("Expense added successfully!");
        } catch (SQLException e) {
            System.err.println("Error adding expense: " + e.getMessage());
        }
    }

    public static List<Expense> getExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String query = "SELECT * FROM expenses";
        try (Connection conn = DataBaseUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                expenses.add(new Expense(rs.getInt("id"), rs.getInt("userId"), rs.getString("category"),
                        rs.getDouble("amount"), rs.getDate("dateSpent")));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching expenses: " + e.getMessage());
        }
        return expenses;
    }
}
