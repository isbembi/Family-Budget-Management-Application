package controller;

import model.Goal;
import utils.DataBaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoalController {
    public static void addGoal(int userId, String goalName, double targetAmount, double currentAmount) {
        String query = "INSERT INTO goals (userId, goalName, targetAmount, currentAmount) VALUES (?, ?, ?, ?)";
        try (Connection conn = DataBaseUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setString(2, goalName);
            stmt.setDouble(3, targetAmount);
            stmt.setDouble(4, currentAmount);
            stmt.executeUpdate();
            System.out.println("Goal added successfully!");
        } catch (SQLException e) {
            System.err.println("Error adding goal: " + e.getMessage());
        }
    }

    public static List<Goal> getGoals() {
        List<Goal> goals = new ArrayList<>();
        String query = "SELECT * FROM goals";
        try (Connection conn = DataBaseUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                goals.add(new Goal(rs.getInt("id"), rs.getInt("userId"), rs.getString("goalName"),
                        rs.getDouble("targetAmount"), rs.getDouble("currentAmount")));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching goals: " + e.getMessage());
        }
        return goals;
    }
}
