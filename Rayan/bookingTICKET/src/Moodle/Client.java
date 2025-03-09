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

    public ArrayList<Movie.genre> Intrests = new ArrayList<>();
    public int Balance;
    

    public Client(String firstName, String lastName,int Age ,String email, String phoneNumber, String username, String password) {

        super(username, password);
        this.FirstName = firstName;
        this.Age = Age;
        this.LastName = lastName;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
    }



}
