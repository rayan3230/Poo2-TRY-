package controller;

import java.util.ArrayList;
import Model.*;

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


}
