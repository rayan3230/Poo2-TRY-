package ManagementClasses;

import java.util.ArrayList;
import java.util.List;

import Personnel.*;

public class Account {

    public Admin admin;
    public Client client;

    public String username;
    public String password;

    public String role;
    public String status;

    public List<Account> Clients = new ArrayList<Account>();
    public List<Account> Admins = new ArrayList<Account>();

    // Admin Account
    public Account(Admin admin, String username, String password, String role, String status) {

        this.admin = admin;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;

    }

    // Client Account
    public Account(Client client, String username, String password) {

        this.client = client;
        this.username = username;
        this.password = password;
    }

    public void AddClient(Account client) {
        Clients.add(client);
    }

    public void AddAdmin(Account admin) {
        Admins.add(admin);
    }

    public void RemoveClient(Account client) {
        Clients.remove(client);
    }

    public void RemoveAdmin(Account admin) {
        Admins.remove(admin);
    }

    public void UpdateClient(Account client, String newFirstName, String newLastName, int newAge, String newEmail,
            String newPhoneNumber) {
        client.client.FirstName = newFirstName;
        client.client.LastName = newLastName;
        client.client.Age = newAge;
        client.client.Email = newEmail;
        client.client.PhoneNumber = newPhoneNumber;
    }

    public void UpdateAdmin(Account admin, String newFirstName, String newLastName, int newID, int newAge) {
        admin.admin.FirstName = newFirstName;
        admin.admin.LastName = newLastName;
        admin.admin.ID = newID;
        admin.admin.Age = newAge;
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
