package Presocalsses;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Client extends Account {
public String FirstName;
public String LastName;
public int Age;
public String Email;
public String PhoneNumber;
public List<String> Intrests = new ArrayList<String>();

public Client(String FirstName, String LastName, int Age, String username, String password, String role, String status) {

    super(username, password, role, status);
    this.FirstName = FirstName;
    this.LastName = LastName;
    this.Age = Age;
}

public void newClient(Account admin, String newFirstName, String newLastName,  int newAge) {
    this.FirstName = newFirstName;
    this.LastName = newLastName;
    this.Age = newAge;
}

    public void GetIntrests() {
        Scanner scanner = new Scanner(System.in);
        List<String> selectedGenres = new ArrayList<>();

System.out.println("Select the movie genres you are interested in (separate choices with spaces): ");
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
System.out.print("Enter your choices (e.g., '1 3 5' to select Action, Drama, and Romance): ");

String input = scanner.nextLine();
String[] choices = input.split(" "); // Séparer les choix par espace

for (String choice : choices) {
try {
int num = Integer.parseInt(choice);
if (num >= 1 && num <= 10) {
String genre = switch (num) {
case 1 -> "Action";
case 2 -> "Comedy";
case 3 -> "Drama";
case 4 -> "Horror";
case 5 -> "Romance";
case 6 -> "Thriller";
case 7 -> "Adventure";
case 8 -> "Fantasy";
case 9 -> "Mystery";
case 10 -> "All genres";
default -> null;
};
if (genre != null && !selectedGenres.contains(genre)) {
selectedGenres.add(genre);
}
} else {
System.out.println("Invalid choice: " + num + " (ignored)");
}
} catch (NumberFormatException e) {
System.out.println("Invalid input: " + choice + " (ignored)");
}
}

if (selectedGenres.isEmpty()) {
System.out.println("No valid selections were made.");
} else {
System.out.println("You selected: " + String.join(", ", selectedGenres));
}
scanner.close(); 
}
public void ShowIntrests() {
        System.out.println("Intrests : ");
        for (String intrest : Intrests) {
            System.out.println(intrest);
        }
    }

}
