package ManagementClasses;

public class Ticket {

    public String name;
    public String Age;
    public int number;
    public Movie movie;
    public int PlaceId;
    public String Type; // VIP, Normal

    enum Type {
        VIP, Normal
    }

    public Ticket(String name, String Age, int number, Movie movie,
            int PlaceId, String Type) {

        this.name = name;
        this.Age = Age;
        this.number = number;
        this.PlaceId = PlaceId;
        this.Type = Type;

        this.movie = movie;
    }

}
