package Controller;
import Moodle.Accounts;
import java.util.ArrayList;

public class GestionAccounts {
    public ArrayList<Accounts> accounts = new ArrayList<>();
    
    public void AddAccount(String username, String password ,String email,double cardNumber , int CCVnbr) {
        for (Accounts account : accounts){
            if (account.username.equals(username)) {
                System.out.println("Account already exists");
                return;
            }else{
                accounts.add(new Accounts(username, password, email ,cardNumber, CCVnbr));
                return;

            }
        }

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

  
}
