package Moodle;

import java.util.ArrayList;

public class Client extends Accounts{

    public String FirstName;
    public String LastName;
    public int Age;
    public String Email;
    public String PhoneNumber;
    public double cardNum;
    public int CCVnbr;
    public int Balance;
    public ArrayList<Movie.genre> Intrests = new ArrayList<>();
    

    public Client(String firstName, String lastName,int Age, int Balance ,String email, String phoneNumber, String username, String password) {

        super(username, password);
        this.FirstName = firstName;
        this.Balance = Balance;
        this.Age = Age;
        this.LastName = lastName;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
    }



}
