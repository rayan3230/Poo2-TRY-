package moodle;

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

    public void ChangeUserName(Account account, String newUserName) {
        account.username = newUserName;
    }

    public void ChangePassword(Account account, String newPassword) {
        account.password = newPassword;
    }

    public void ChangeRole(Account account, String NewRole) {
        account.role = NewRole;
    }

    public void ChangeStatus(Account account, String NewStatus) {
        account.status = NewStatus;
    }

    public boolean CheckCredentials(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

}
