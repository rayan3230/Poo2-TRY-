package Presocalsses;

public class Admin extends Account {
public String FirstName;
public String LastName;
public int ID;
public int Age;
public String Email;
public String PhoneNumber;
public Admin(String FirstName, String LastName, int ID, int Age, String username, String password, String role, String status) {

    super(username, password, role, status);
    this.FirstName = FirstName;
    this.LastName = LastName;
    this.ID = ID;
    this.Age = Age;
}

public void newAdmin(Account admin, String newFirstName, String newLastName, int newID, int newAge) {
    this.FirstName = newFirstName;
    this.LastName = newLastName;
    this.ID = newID;
    this.Age = newAge;
}

}

