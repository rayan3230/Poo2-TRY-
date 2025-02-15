package Users_Classees;

public class User {

    private String username;
    private String password;
    private String role;

    enum role {
        ADMIN, CUSTOMER
    }

    public User(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;

    }

    public String getusername(){
        return this.username;
    }

    public String getpassword(){
        return this.password;
    }

    public String getrole(){
        return this.role;
    }

    public void setusername(String username){
        this.username = username;
    }

    public void setpassword(String password){
        this.password = password;
    }

    public void setrole(String role){
        this.role = role;
    }

}
