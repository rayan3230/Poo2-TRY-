package Model;

import java.util.ArrayList;

public class Client extends Account{

    public String FirstName;
    public String LastName;
    public int Age;
    public double PhoneNumber;
    public double CardNumber;
    public int CCVNumber;
    public double Balance;
    public ArrayList<IntrestsEnum> UserIntrests = new ArrayList<>();

    public enum IntrestsEnum {
        Action, 
        Comedy,
        Drama, 
        Horror, 
        Romance, 
        Thriller, 
        Adventure, 
        Fantasy, 
        Mystery;
    }

    public Client(String firstName, String lastName, String email, double phoneNumber, String username,
         String password,double CardNumber,int CCVNumber, Status status) {

        super(username, password, email,"client", status);
        this.FirstName = firstName;
        this.LastName = lastName;
        this.PhoneNumber = phoneNumber;
        this.CardNumber = CardNumber;
        this.CCVNumber = CCVNumber;
        this.Balance = 0;
    }

    public void UpdateClient(Account client, String newFirstName, String newLastName, int newAge, String newEmail,double newPhoneNumber) {
        this.FirstName = newFirstName;
        this.LastName = newLastName;
        this.Age = newAge;
        this.email = newEmail;
        this.PhoneNumber = newPhoneNumber;
    }

    public void AddIntrest(IntrestsEnum intrest) {
        UserIntrests.add(intrest);
    }

    public void RemoveIntrest(IntrestsEnum intrest) {
        UserIntrests.remove(intrest);
    }

    public void ShowIntrests() {
        System.out.println("Intrests : ");
        for (IntrestsEnum intrest : UserIntrests) {
            System.out.println(intrest);
        }
    }

}
