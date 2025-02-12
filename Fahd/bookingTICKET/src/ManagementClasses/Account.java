package ManagementClasses;

import java.util.ArrayList;
import java.util.List;

import Personnel.*;

public class Account {
    public String username;
    public String password;
    public String email;
    public String phoneNumber;
    public String address;
    public String name;
    public String lastName;
    public String id;
    public String role;
    public String status;

    public List<Client> clients = new ArrayList<Client>();
    public List<Admin> admins = new ArrayList<Admin>();

    public Account(String username, String password, String email, String phoneNumber,
            String address, String name, String lastName, String id, String role, String status) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.role = role;
        this.status = status;

    }

    public void AddClient(Client client) {
        clients.add(client);
    }

    public void AddAdmin(Admin admin) {
        admins.add(admin);
    }

    public void RemoveClient(Client client) {
        clients.remove(client);
    }

    public void RemoveAdmin(Admin admin) {
        admins.remove(admin);
    }

    public void UpdateClient(Client client, String newFirstName, String newLastName, String newAge, String newEmail,
            String newPhoneNumber) {
        client.FirstName = newFirstName;
        client.LastName = newLastName;
        client.Age = newAge;
        client.Email = newEmail;
        client.PhoneNumber = newPhoneNumber;
    }

    public void UpdateAdmin(Admin admin, String newFirstName, String newLastName, String newID, int newAge) {
        admin.FirstName = newFirstName;
        admin.LastName = newLastName;
        admin.ID = newID;
        admin.Age = newAge;
    }

}
