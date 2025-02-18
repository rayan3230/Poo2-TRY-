package Moodle;

public class Accounts {
    public String username;
    public String password;
    public String email;
    public double cardNumber;
    public int CCVnbr;
    public double balance;
    
    public Accounts(String username, String password, String email, double cardNumber, int CCVnbr) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.cardNumber = cardNumber;
        this.CCVnbr = CCVnbr;
        this.balance = 0.0;
    }
    public Accounts(double balance){
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }

  


}
