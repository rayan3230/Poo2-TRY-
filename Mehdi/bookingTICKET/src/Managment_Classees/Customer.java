package Managment_Classees;

import Basic_Classes.Diffusion;

public class Customer extends User {

    private String email;
    private String phone;

    public Customer(String username, String password, String role, String email, String phone) {
        super(username, password, role);
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void WatchMovieList(){


    }

    public void bookTicket(Diffusion diffusion, int seat, double price) {
        
        
    }

}
