package view;

import java.sql.*;

public class DB {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL driver
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL driver error", e);
        }

        // Update these values:
        String url = "jdbc:mysql://localhost:3306/test1?serverTimezone=UTC&useSSL=false";
        String user = "root"; // Use your MySQL username
        String password = "wass 2006"; // Use your MySQL password

        return DriverManager.getConnection(url, user, password);
    }

    public static void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(100) NOT NULL, "
                + "email VARCHAR(100) NOT NULL, "
                + "password VARCHAR(100) NOT NULL, "
                + "role BOOLEAN NOT NULL"
                + ")";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table 'users' created successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void registerUser(String name, String email, String password, boolean role) {
        String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setBoolean(4, role);
            pstmt.executeUpdate();
            System.out.println("User registered!");
        } catch (SQLException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }

    public static boolean loginUser(String email, String password, boolean role) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ? AND role = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setBoolean(3, role);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return true; // Login successful
            } else {
                return false; // Login failed
            }
        } catch (SQLException e) {
            System.out.println("Login failed: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Connection successful!");
            createTable(); // Call the method to create the table
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}