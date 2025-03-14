package Personnel;

import MainClasses.Cinema;
import ManagementClasses.*;
import java.util.ArrayList;
import java.util.List;

public class Client extends Account{

    public String FirstName;
    public String LastName;
    public int Age;
    public String Email;
    public String PhoneNumber;
    public double cardNum;
    public int CCVnbr;
    public List<Cinema.Genre> Intrests = new ArrayList<>();

    public Client(String firstName, String lastName, String email, String phoneNumber, String username, String password) {

        super(username, password);
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
    }

    public void UpdateClient(Account client, String newFirstName, String newLastName, int newAge, String newEmail,
            String newPhoneNumber) {
        this.FirstName = newFirstName;
        this.LastName = newLastName;
        this.Age = newAge;
        this.Email = newEmail;
        this.PhoneNumber = newPhoneNumber;
    }

}
