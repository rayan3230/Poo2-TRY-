package ManagementClasses;

public class Movie {

    public String Title;
    public String Genre;
    public int Duration; // in hours
    public String Description;
    public String Director;
    public String Cast;
    public String ReleaseDate;
    public int Rating; // out of 10
    public String AgeRating; // G, PG13, PG16, PG18
    public Theater Room;

    enum Genre {
        Action, Adventure, Comedy, Drama, Fantasy, Horror, Mystery, Romance, Thriller
    }

    enum AgeRating {
        G, PG13, PG16, PG18
    }

    public Movie(String Title, String Genre, int Duration, String Description, String Director, String Cast,
            String ReleaseDate, int Rating, String AgeRating, Theater Room) {

        this.Title = Title;
        this.Genre = Genre;
        this.Duration = Duration;
        this.Description = Description;
        this.Director = Director;
        this.Cast = Cast;
        this.ReleaseDate = ReleaseDate;
        this.Rating = Rating;
        this.AgeRating = AgeRating;
        this.Room = Room;
    }

}
