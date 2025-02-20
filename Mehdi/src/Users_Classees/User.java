package Users_Classees;

public class User {

    private String username;
    private String password;

    
    public User(String username, String password, String role){
        this.username = username;
        this.password = password;
    }

    public String getusername(){
        return this.username;
    }

    public String getpassword(){
        return this.password;
    }

    public void setusername(String username){
        this.username = username;
    }

    public void setpassword(String password){
        this.password = password;
    }

}
