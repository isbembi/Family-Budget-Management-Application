package controller;

import model.User;
import utils.DataBaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    public static void addUser(String name, String email, String password, String userType, int salary) {
        String query = "INSERT INTO user (name, email, password, user_type, salary) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DataBaseUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, userType);
            stmt.setInt(5, salary);
            stmt.executeUpdate();
            System.out.println("User added successfully!");
        } catch (SQLException e) {
            System.err.println("Error while adding user: " + e.getMessage());
        }
    }

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        try (Connection conn = DataBaseUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
                        rs.getString("password"), rs.getString("user_type"), rs.getInt("salary")));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching users: " + e.getMessage());
        }
        return users;
    }
}
