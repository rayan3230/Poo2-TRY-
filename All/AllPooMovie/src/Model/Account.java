package Model;

public class Account {

    public String username;
    public String password;

    public String role;
    public String status;

    enum Status{
        admin, manager
    }

    // Admin Account
    public Account(String username, String password, String role, String status) {

        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;

    }

    // Client Account
    public Account(String username, String password) {

        this.username = username;
        this.password = password;
    }

}
