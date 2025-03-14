package controller;

import Model.*;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;

public class ClientManager {
    
    public ArrayList<Client> clients;

    // public ClientManager() {
    //     clients = new ArrayList<>();
    //     //Create a default client
    //     Client client1 = new Client("rayan", "mozali", "rayanmozali@gmail.com", 
    //             "0000", "rayan", "momo");
    //     addClient(client1);
    // }
    
    // public void addClient(Client client) {
    //     clients.add(client);
    // }

    // public void removeClient(Client client) {
    //     clients.remove(client);
    // }
    
    public ClientManager(){}


    public boolean isClient(String username, String password ){
        //Check if the client credentials match with the stored client credentials
        for(Client client : clients){
            if((client.username.equals(username) || client.Email.equals(username) || client.PhoneNumber.equals(username))
                && (client.password.equals(password))){
                return true;
            }
        }
        
        //If client credentials don't match, add the client to the clients list
        return false;
    }

    
    public Client getClient(String username, String password){
        //Check if the client credentials match with the stored client credentials
        for(Client client : clients){
            if((client.username.equals(username) || client.Email.equals(username) || client.PhoneNumber.equals(username))
                && (client.password.equals(password))){
                return client;
            }
        }
        
        //If client credentials don't match, return null
        return null;
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

        public static void updateClientName(int userID, String username, String lname, String name) {
        String sql = "UPDATE users SET username = ?, LastName = ?, Name = ? WHERE UserID = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, lname);
            pstmt.setString(3, name);
            pstmt.setInt(4, userID);

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
            System.out.println("User name updated successfully!");
            } else {
            System.out.println("User not found. No update performed.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

        public static void updateClientEmail(int userID, String email) {
        String sql = "UPDATE users SET Email = ? WHERE UserID = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setInt(2, userID);

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
            System.out.println("User email updated successfully!");
            } else {
            System.out.println("User not found. No update performed.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

        public static void updateClientPassword(int userID, String password) {
        String sql = "UPDATE users SET Password = ? WHERE UserID = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, password);
            pstmt.setInt(2, userID);

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
            System.out.println("User password updated successfully!");
            } else {
            System.out.println("User not found. No update performed.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

        public static void updateClientAge(int userID, int age) {
        String sql = "UPDATE users SET Age = ? WHERE UserID = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, age);
            pstmt.setInt(2, userID);

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
            System.out.println("User age updated successfully!");
            } else {
            System.out.println("User not found. No update performed.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

        public static void updateClientBalance(int userID, int balance) {
        String sql = "UPDATE users SET Balance = ? WHERE UserID = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, balance);
            pstmt.setInt(2, userID);

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
            System.out.println("User balance updated successfully!");
            } else {
            System.out.println("User not found. No update performed.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

        public static boolean userExists(String username, String email, String password) {
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

        public static ResultSet findUsersbyusername(String username) {
            String sql = "SELECT * FROM users WHERE username = ? ";

            try (Connection conn = DatabaseConnection.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, username);

                return pstmt.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }

        
        public static ResultSet findUsersbyEmail(String email) {
            String sql = "SELECT * FROM users WHERE Emaik = ? ";

            try (Connection conn = DatabaseConnection.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, email);

                return pstmt.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }



        public static int numberofusers() {
            String sql = "SELECT COUNT(*) FROM users";
    
            try (Connection conn = DatabaseConnection.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    return rs.getInt(1);
                }
    
            } catch (SQLException e) {
                e.printStackTrace();
            }
    
            return 0;
        }

        public static int averagebalance() {
            String sql = "SELECT AVG(Balance) FROM users";
    
            try (Connection conn = DatabaseConnection.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    return rs.getInt(1);
                }
    
            } catch (SQLException e) {
                e.printStackTrace();
            }
    
            return 0;
        }



}
