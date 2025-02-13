package ManagementClasses;

public class Ticket {

    public int number;
    public Movie movie;
    public String Type; // VIP, Normal
    public String Date;

    enum Type {
        VIP, Normal
    }

    public Ticket(int number, String Type, String Date, Movie movie) {

        this.number = number;
        this.Type = Type;
        this.Date = Date;

        this.movie = movie;
    }

}
