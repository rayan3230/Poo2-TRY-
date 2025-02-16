package controll;
import model.admin;
import model.client;

public class Authentication {

    private String email;
    private String name;
    private String address;
    private String role;
    private String password;
    public boolean authenticate(String email ,String username, String password, boolean isAdmin) {
        if (isAdmin) {
            this.email = email;
            this.password = password;
            this.name = username;
            admin admin = new admin(username, email, password);
            // Add your authentication logic here
            return true; // Return true if authentication is successful
        } else {
            // Assuming you have the necessary information for email, phone, and address
            this.email = email;
            this.password = password;
            this.name = username;
            this.address = "123 Main St"; // Replace with actual address
            client client = new client(username, email, password);
            // Add your authentication logic here
            return true; // Return true if authentication is successful
        }
    }
}
