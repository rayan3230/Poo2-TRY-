package controller;

import java.sql.*;

public class ClientManager {
    

    public ClientManager() {

    }
    
    static public void addClient(String name,String email,String password,int Age,int balance) {
        String sql = "INSERT INTO users (Name, Email, Password,Age, Balance) VALUES ('"
                 + name + "', '" + email + "', '" + password + "', " + Age + ", " + balance + ")";
    
    try (Connection conn = DatabaseConnection.connect();
         Statement stmt = conn.createStatement()) {
        
        int rowsInserted = stmt.executeUpdate(sql); // Directly executing SQL query
        
        if (rowsInserted > 0) {
            System.out.println("User added successfully!");
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }

    }

    static public void removeClient(int UserID) {
        String sql = "DELETE FROM users WHERE UserID = " + UserID;

        try (Connection conn = DatabaseConnection.connect();
        Statement stmt = conn.createStatement()) {
        
            int rowsDeleted = stmt.executeUpdate(sql);
            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully!");
            }else {
                System.out.println("User not found. No deletion performed.");
            }    
            
        }
         catch (SQLException e) {
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


    public static void main(String[] args) {
        //ClientManager.addClient("wassim","wassim","wassim",30);
        ClientManager.removeClient(1);
    }
}
