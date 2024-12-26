package utils;

import java.sql.*;

public class DataBaseUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/familybudget";
    private static final String USER = "root";  // Ваш MySQL пользователь
    private static final String PASSWORD = "9497980204Bem-Bem";  // Ваш MySQL пароль

    // Метод для установки соединения с базой данных
    public static Connection getConnection() throws SQLException {
        try {
            // Регистрация драйвера (в новых версиях Java это не обязательно, но добавлено для совместимости)
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC Driver not found", e);
        }
    }
}
