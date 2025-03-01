package Model;

public class Account {

    public String username;
    public String password;
    public String role;
    public String email;
    public Status status;

    public enum Status{
        admin,
        manager,
        client
    }

    // Admin Account
    public Account(String username, String password,String email, String role, Status status) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.status = status;

    }

    // Client Account
    public Account(String username, String password , Status status) {

        this.username = username;
        this.password = password;
        this.status = status;
    }

    public void ChangeUserName(Account account, String newUserName) {
        account.username = newUserName;
    }

    public void ChangePassword(Account account, String newPassword) {
        account.password = newPassword;
    }

    public void ChangeRole(Account account, String NewRole) {
        account.role = NewRole;
    }

    public void ChangeStatus(Account account, Status NewStatus) {
        account.status = NewStatus;
    }

    public boolean CheckCredentials(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

}
