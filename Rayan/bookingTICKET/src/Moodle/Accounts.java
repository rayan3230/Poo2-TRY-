package Moodle;

public class Accounts {
    public String username;
    public String password;
    public String email;
    public double cardNumber;
    public int CCVnbr;
    
    public Accounts(String username, String password, String email, double cardNumber, int CCVnbr) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.cardNumber = cardNumber;
        this.CCVnbr = CCVnbr;
    }

    public Accounts(String username, String password){
        this.username = "admin";
        this.password = "admin";

    }


}
