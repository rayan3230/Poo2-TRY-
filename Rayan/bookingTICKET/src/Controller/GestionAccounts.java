package Controller;
import Moodle.Accounts;
import java.util.ArrayList;

public class GestionAccounts {
    public ArrayList<Accounts> accounts = new ArrayList<>();
    public ArrayList<Accounts> AdminAccounts = new ArrayList<>();

    public GestionAccounts(){
        accounts.add(new Accounts("Rayan3230", "q", "q@gmail.com", 1234567890, 123));
        accounts.add(new Accounts("Wassim222", "w", "" + 1234567890, 1234567890, 123));
        
        
        AdminAccounts.add(new Accounts("admin", "admin", "admin@gmail.com", 0, 0));
    }
    
    public void AddAccount(String username, String password ,String email,double cardNumber , int CCVnbr) {
        for (Accounts account : accounts){
            if (account.username.equals(username)) {
                System.out.println("Account already exists");
                return;
            }
        }
        accounts.add(new Accounts(username, password, email ,cardNumber, CCVnbr));
        System.out.println("Account created successfully");

   }        
   public Boolean CheckAccountIfCreated(String Email , String password){
    for (Accounts account : accounts){
            if (account.email.equals(Email) && account.password.equals(password)) {
                return true;
            }
        }
        return false;
    }
    public void UpdateAccount(String username, String newPassword) {
        for (Accounts account : accounts) {
            if (account.username.equals(username)) {
                account.password = newPassword;
                return;
            }
        }
        System.out.println("Account not found");
    }
    public void DeleteAccount(String username) {
        for (Accounts account : accounts) {
            if (account.username.equals(username)) {
                accounts.remove(account);
                return;
            }
        }
        System.out.println("Account not found");
    }


    public void RemoveAccount(String username) {
        for (Accounts account : accounts) {
            if (account.username.equals(username)) {
                accounts.remove(account);
                return;
            }
        }
        System.out.println("Account not found");
    }
    public boolean isAdmin(String email, String password) {
        for (Accounts admin : AdminAccounts) {
            if (admin.email.equals(email) && admin.password.equals(password)) {
                return true;
            }
        }
        return false;
    }
    public Accounts getAccountuser(String email, String password) {
        for (Accounts account : accounts) {
            if (account.email.equals(email)) {
                return account;
            }
        }
        return null;
    }

    public Accounts getAccountadmin(String email, String password) {
        for (Accounts account : AdminAccounts) {
            if (account.email.equals(email)) {
                return account;
            }
        }
        return null;
    }


    public void addBalance(Accounts account , double amount){
        account.balance += amount;
        System.out.println("Your new balance is: " + account.cardNumber);

    }
}


  

  

