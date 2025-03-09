package Controller;
import Moodle.*;
import java.util.ArrayList;

public class GestionAccounts {
    public ArrayList<Admin> Admins = new ArrayList<>();
    public ArrayList<Client> Clients = new ArrayList<>();

    public GestionAccounts(){
        Clients.add(new Client("Rayan3230", "q", 12,"q@gmail.com", "1234567890", "rayan32","123"));
        Clients.add(new Client("Wassim222", "w", 22,"" , "1234567890", "1234567890", "123"));
        Clients.add(new Client("Fahd", "Djedi", 10,"fahd@gmail.com", "055098765432", "fahd3123", "zxcvbnm"));
        Clients.add(new Client("Mohammed", "Mohamed", 30,"mohammed@gmail.com", "055098765432", "mohammed123", "qwer"));
        Clients.add(new Client("Mahmoud", "Mahmoud", 77,"mahmoud@gmail.com", "055098765432", "mahmoud123", "asdf"));
        Clients.add(new Client("Hassan", "Hassan", 45,"hassan@gmail.com", "055098765432", "hassan123", "jkl"));
        Clients.add(new Client("Mehdi","Benazza",19,"Mehdi@gmail.com","0478574834343","Mehdi7478","edfdf"));
        
        
       // AdminAccounts.add(new Accounts("admin", "admin", "admin@gmail.com", 0, 0));
    }
    
    public void AddClientAccount(String firstname,String lastname , int Age ,String phonenumber , String username  ,String password ,String email,double cardNumber , int CCVnbr ) {
        for (Client account : Clients){
            if (account.username.equals(username)) {
                System.out.println("Account already exists");
                return;
            }
        }
        Clients.add(new Client(firstname, lastname , Age ,email, phonenumber , username ,password ));
        System.out.println("Account created successfully");

   }        
   public Boolean CheckAccountIfCreated(String Email , String password){
    for (Client account : Clients){
            if (account.Email.equals(Email) && account.password.equals(password)) {
                return true;
            }
        }
        return false;
    }
    public void UpdateAccount(String username, String newPassword) {
        for (Client account : Clients) {
            if (account.username.equals(username)) {
                account.password = newPassword;
                return;
            }
        }
        System.out.println("Account not found");
    }
    public void DeleteAccount(String username) {
        for (Client account : Clients) {
            if (account.username.equals(username)) {
                Clients.remove(account);
                return;
            }
        }
        System.out.println("Account not found");
    }


    public void RemoveAccount(String username) {
        for (Client account : Clients) {
            if (account.username.equals(username)) {
                Clients.remove(account);
                return;
            }
        }
        System.out.println("Account not found");
    }
    // public boolean isAdmin(String email, String password) {
    //     for (Accounts admin : AdminAccounts) {
    //         if (admin.email.equals(email) && admin.password.equals(password)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    public Accounts getAccountuser(String email, String password) {
        for (Client account : Clients) {
            if (account.Email.equals(email)) {
                return account;
            }
        }
        return null;
    }

    // public Accounts getAccountadmin(String email, String password) {
    //     for (Accounts account : AdminAccounts) {
    //         if (account.email.equals(email)) {
    //             return account;
    //         }
    //     }
    //     return null;
    // }


    public void addBalance(Client Client , double amount){
        Client.Balance += amount;
        System.out.println("Your new balance is: " + Client.cardNum);

    }
}


  

  

