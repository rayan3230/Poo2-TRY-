package controller;

import java.sql.*;

public class ClientManager {
    

    public ClientManager() {

    }
    
    public static void addClient(String name, String email, String password, int age, int balance) {
        String sql = "INSERT INTO users (Name, Email, Password, Age, Balance) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setInt(4, age);
            pstmt.setInt(5, balance);
            
            int rowsInserted = pstmt.executeUpdate();
            
            if (rowsInserted > 0) {
                System.out.println("User added successfully!");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    


    
    /*public Client getClient(String username, String password){
        //Check if the client credentials match with the stored client credentials
        for(Client client : clients){
            if((client.username.equals(username) || client.Email.equals(username) || client.PhoneNumber.equals(username))
                && (client.password.equals(password))){
                return client;
            }
        }
        
        //If client credentials don't match, return null
        return null;
    }*/



}
