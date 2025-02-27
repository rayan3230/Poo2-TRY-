package controller;
import java.util.ArrayList;
import moodle.*;
import moodle.Account.Status;

public class GestionAccounts {
    public ArrayList<Client> ClientAccounts = new ArrayList<>();
    public ArrayList<Admin> AdminAccounts = new ArrayList<>();

    public GestionAccounts(){
        ClientAccounts.add(new Client("Rayan","Moza","rayan@gmail.com",1234567890,"rayan","1234",123456789, 123,Account.Status.client));
        // Add admin account
        AdminAccounts.add(new Admin("Fahd","djedi","fahd@gmail.com","fahd","1234",Account.Status.admin));
    }
    
    public void AddClient(String firstname,String lastname,String email,double phonenumber , String username ,String password ,double cardNumber , int CCVnbr) {
        for (Client account : ClientAccounts){
            if (account.username.equals(username)) {
                System.out.println("Account already exists");
                return;
            }
        }
        ClientAccounts.add(new Client(firstname, lastname, email, phonenumber, username, password, cardNumber, CCVnbr, Status.client));
        System.out.println("Account created successfully");

   }        
   public Boolean CheckClientAccountIfCreated(String Email , String password){
    for (Client account : ClientAccounts){
            if (account.email.equals(Email) && account.password.equals(password)) {
                return true;
            }
        }
        return false;
    }
    public void UpdateClientAccount(String username, String newPassword) {
        for (Client account : ClientAccounts) {
            if (account.username.equals(username)) {
                account.password = newPassword;
                return;
            }
        }
        System.out.println("Account not found");
    }
    public void DeleteClientAccount(String username) {
        for (Client account : ClientAccounts) {
            if (account.username.equals(username)) {
                ClientAccounts.remove(account);
                return;
            }
        }
        System.out.println("Account not found");
    }


    public void RemoveClientAccount(String username) {
        for (Client account : ClientAccounts) {
            if (account.username.equals(username)) {
                ClientAccounts.remove(account);
                return;
            }
        }
        System.out.println("Account not found");
    }
    public boolean isAdmin(String email, String password) {
        for (Admin admin : AdminAccounts) {
            if (admin.email.equals(email) && admin.password.equals(password)) {
                return true;
            }
        }
        return false;
    }
    public Client getClientAccount(String email, String password) {
        for (Client account : ClientAccounts) {
            if (account.email.equals(email)) {
                return account;
            }
        }
        return null;
    }

    public Admin getAdminAccount(String email, String password) {
        for (Admin account : AdminAccounts) {
            if (account.email.equals(email)) {
                return account;
            }
        }
        return null;
    }


    public void addBalance(Client account , double amount){
        account.Balance += amount;
        System.out.println("Your new balance is: " + account.CardNumber);

    }
}


  

  

