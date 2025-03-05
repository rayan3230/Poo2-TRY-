package Model;

public class Admin extends Account{

    public int ID;
    public String FirstName;
    public String LastName;
    public int Age;
    public String Email;
    public String PhoneNumber;

    public Admin(String FirstName, String LastName, String username, String password, Status status) {

        super(username, password, "Admin", status.admin);
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

}
