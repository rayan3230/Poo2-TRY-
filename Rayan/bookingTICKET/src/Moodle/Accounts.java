package Moodle;

public class Accounts {
    public String username;
    public String password;
    public Status status;

    public enum Status{
        Admin,
        Manager
    }

    // Admin Account
    public Accounts(String username, String password, Status status) {

        this.username = username;
        this.password = password;
        this.status = status;

    }

    // Client Account
    public Accounts(String username, String password) {

        this.username = username;
        this.password = password;
    }

  


}
