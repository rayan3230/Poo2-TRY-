package ManagementClasses;

public class Filters {

    public String Genre = "NULL";
    public String AgeRestriction = "NULL";
    public float Duration = 0f;
    public int Rating = 0;
    public String Date = "NULL";
    public String TicketType = "NULL";
    public String ReleaseDate = "NULL";
    public int[] Seats = { 0, 0 };
    public String Name = "NULL";

    enum Genre {
        Action, Comedy, Drama, Horoor, Science_Fiction, Thriller, Adventure, Fantasy, Mystery, Romance, Crime,
        Animation, Music, Documentary, Family, Sport, News, Travel, Game, History
    }

    enum AgeRestriction {
        G, PG6, PG8, PG13, PG16, PG18
    }

    enum TicketType {
        VIP, Normal, NULL
    }

    public void SetGenreFilter(String Genre) {
        this.Genre = Genre;
    }

    public void SetAgeRestrictionFilter(String AgeRestriction) {
        this.AgeRestriction = AgeRestriction;
    }

    public void SetDurationFilter(int Duration) {
        this.Duration = Duration;
    }

    public void SetRatingFilter(int Rating) {
        this.Rating = Rating;
    }

    public void SetDateFilter(String Date) {
        this.Date = Date;
    }

    public void SetTicketTypeFilter(String TicketType) {
        this.TicketType = TicketType;
    }

    public void SetReleaseDateFilter(String ReleaseDate) {
        this.ReleaseDate = ReleaseDate;
    }

    public void SetSeatsFilter(int[] Seats) {
        this.Seats = Seats;
    }

    public void SetNameFilter(String Name) {
        this.Name = Name;
    }

    public void DisplayFilters() {

        System.out.println("Genre: " + Genre);
        System.out.println("Age Restriction: " + AgeRestriction);
        System.out.println("Duration: " + Duration);
        System.out.println("Rating: " + Rating);
        System.out.println("Date: " + Date);
        System.out.println("Ticket Type: " + TicketType);
        System.out.println("Release Date: " + ReleaseDate);
        System.out.println("Seats: " + Seats);
        System.out.println("Name: " + Name);
    }

}
