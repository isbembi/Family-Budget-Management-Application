package utils;

import java.sql.*;

public class CRUD extends DataBaseUtils{
    //method for adding the new user
    public static void addUser(String name, String email, String password, String user_type, int salary ) {
        String query = "INSERT INTO user (name, email, password, user_type, salary) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, user_type);
            stmt.setInt(5, salary);
            stmt.executeUpdate();
            System.out.println("User added successfully!");
        } catch (SQLException e) {
            System.err.println("Error while adding user: " + e.getMessage());
        }
    }
    public static void getUsers() {   //selects all users
        String query = "SELECT * FROM user";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching users: " + e.getMessage());
        }

    }
    //adding new expense
    public static void addExpense(int userId, String category, double amount, String dateSpent){
        String query = "INSERT INTO expenses (userId, category, amount, dateSpent) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setString(2, category);
            stmt.setDouble(3, amount);
            stmt.setString(4, dateSpent); // Дата должна быть в формате "yyyy-MM-dd"
            stmt.executeUpdate();
            System.out.println("Expense added successfully!");
        } catch (SQLException e) {
            System.err.println("Error while adding expense: " + e.getMessage());
        }
    }
}
