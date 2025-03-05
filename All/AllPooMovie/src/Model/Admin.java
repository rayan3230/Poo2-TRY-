package Model;

public class Admin extends Account{

    public String FirstName;
    public String LastName;
    public int ID;
    public int Age;
    public String Email;
    public String PhoneNumber;

    public Admin(String FirstName, String LastName, String username, String password, String status) {

        super(username, password, "Admin", status);
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public void UpdateAdmin(Account admin, String newFirstName, String newLastName, int newID, int newAge) {
        this.FirstName = newFirstName;
        this.LastName = newLastName;
        this.ID = newID;
        this.Age = newAge;
    }

}
