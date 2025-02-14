package Managment_Classees;

public class Admin extends User {

    public String email;

    public Admin(String username, String password, String role, String email) {
        super(username, password, role);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addmovie(){


    }

    public void deletemovie(){


    }

    public void modifymovie(){


    }

}
