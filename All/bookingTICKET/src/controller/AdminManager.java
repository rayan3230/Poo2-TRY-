package controller;

import Model.*;
import java.sql.*;
import java.util.ArrayList;

public class AdminManager {

    public ArrayList<Admin> admins;

    public AdminManager() {
        admins = new ArrayList<>();
        //Create a default admin
        Admin admin1 = new Admin("fahd", "djedi", "fahd", "fahd@gmail.com", "yuji", Account.Status.Manager);

        addAdmin(admin1);
    }
    
    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public void removeAdmin(Admin admin) {
        admins.remove(admin);
    }
    
    public boolean isAdmin(String username, String password ){
        //Check if the admin credentials match with the stored admin credentials
        for(Admin admin : admins){
            if((admin.username.equals(username) || admin.Email.equals(username) || admin.PhoneNumber.equals(username))
                 && admin.password.equals(password)){
                return true;
            }
        }
        
        return false;
    }
    
    public Admin getAdmin(String username, String password){
        //Check if the client credentials match with the stored client credentials
        for(Admin admin : admins){
            if((admin.username.equals(username) || admin.Email.equals(username) || admin.PhoneNumber.equals(username))
                && (admin.password.equals(password))){
                return admin;
            }
        }
        //If client credentials don't match, return null
        return null;
    }
    
    static public void addAdmin(String name,String email,String password,Boolean status) {
        String sql = "INSERT INTO admins (Name, Email, Password,Status) VALUES ('"
                 + name + "', '" + email + "', '" + password + "', " + status +  ")";
    
    try (Connection conn = DatabaseConnection.connect();
         Statement stmt = conn.createStatement()) {
        
        int rowsInserted = stmt.executeUpdate(sql); // Directly executing SQL query
        
        if (rowsInserted > 0) {
            System.out.println("Admin added successfully!");
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }

    }


        static public void removeAdmin(int AdminID) {
        String sql = "DELETE FROM admins WHERE AdminID = " + AdminID;

        try (Connection conn = DatabaseConnection.connect();
        Statement stmt = conn.createStatement()) {
        
            int rowsDeleted = stmt.executeUpdate(sql);
            if (rowsDeleted > 0) {
                System.out.println("Admin deleted successfully!");
            }else {
                System.out.println("Admin not found. No deletion performed.");
            }    
            
        }
         catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
