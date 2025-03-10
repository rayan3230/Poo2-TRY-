package controller;

import java.sql.*;
import javax.swing.JOptionPane;

public class ClientManager {

    public ClientManager() {

    }

    public static Boolean addClient(String username, String lname, String name, String email, String password, int age, int balance) {
        if (isDuplicate(username, email, password)) {
            JOptionPane.showMessageDialog(null, "User already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String sql = "INSERT INTO users (username, LastName, Name, Email, Password, Age, Balance) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, lname);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.setString(5, password);
            pstmt.setInt(6, age);
            pstmt.setInt(7, balance);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("User added successfully!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static void removeClient(int userID) {
        String sql = "DELETE FROM users WHERE UserID = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userID);

            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully!");
            } else {
                System.out.println("User not found. No deletion performed.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean isDuplicate(String username, String email, String password) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ? OR Email = ? OR Password = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void updateClient(int userID, String username, String lname, String name, String email, String password, int age, int balance) {
        String sql = "UPDATE users SET username = ?, LastName = ?, Name = ?, Email = ?, Password = ?, Age = ?, Balance = ? WHERE UserID = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, lname);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.setString(5, password);
            pstmt.setInt(6, age);
            pstmt.setInt(7, balance);
            pstmt.setInt(8, userID);

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("User updated successfully!");
            } else {
                System.out.println("User not found. No update performed.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }}

        public static boolean userexist(String username, String email, String password) {
            String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND Email = ? AND Password = ?";
    
            try (Connection conn = DatabaseConnection.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
                pstmt.setString(1, username);
                pstmt.setString(2, email);
                pstmt.setString(3, password);
    
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
    
            } catch (SQLException e) {
                e.printStackTrace();
            }
    
            return false;
        }

}
