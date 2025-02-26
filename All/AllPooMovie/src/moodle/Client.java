package moodle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client extends Account{

    public String FirstName;
    public String LastName;
    public int Age;
    public String Email;
    public String PhoneNumber;
    public double cardNum;
    public int CCVnbr;
    public List<String> Intrests = new ArrayList<String>();

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

    public void GetIntrests() {

        System.out.println("Select a movie genre you are intrested in : ");
        System.out.println("1. Action");
        System.out.println("2. Comedy");
        System.out.println("3. Drama");
        System.out.println("4. Horror");
        System.out.println("5. Romance");
        System.out.println("6. Thriller");
        System.out.println("7. Adventure");
        System.out.println("8. Fantasy");
        System.out.println("9. Mystery");
        System.out.println("10. All");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Intrests.add("Action");
                break;
            case 2:
                Intrests.add("Comedy");
                break;
            case 3:
                Intrests.add("Drama");
                break;
            case 4:
                Intrests.add("Horror");
                break;
            case 5:
                Intrests.add("Romance");
                break;
            case 6:
                Intrests.add("Thriller");
                break;
            case 7:
                Intrests.add("Adventure");
                break;
            case 8:
                Intrests.add("Fantasy");
                break;
            case 9:
                Intrests.add("Mystery");
                break;
            case 10:
                Intrests.add("Action");
                Intrests.add("Comedy");
                Intrests.add("Drama");
                Intrests.add("Horror");
                Intrests.add("Romance");
                Intrests.add("Thriller");
                Intrests.add("Adventure");
                Intrests.add("Fantasy");
                Intrests.add("Mystery");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        scanner.close();

    }

    public void AddIntrest(String intrest) {
        Intrests.add(intrest);
    }

    public void RemoveIntrest(String intrest) {
        Intrests.remove(intrest);
    }

    public void ShowIntrests() {
        System.out.println("Intrests : ");
        for (String intrest : Intrests) {
            System.out.println(intrest);
        }
    }

}
