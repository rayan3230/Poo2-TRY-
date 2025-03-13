package Model;

import java.util.ArrayList;

public class Client extends Account{

    public String FirstName;
    public String LastName;
    public int Age;
    public String Email;
    public String PhoneNumber;
    public double cardNum;
    public int CCVnbr;
    public int Balance;
    public ArrayList<Movie.MovieGenre> Intrests = new ArrayList<>();
    

    public Client(String firstName, String lastName, String email, String phoneNumber, String username, String password) {

        super(username, password);
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
        this.Balance = 0;
    }



}
