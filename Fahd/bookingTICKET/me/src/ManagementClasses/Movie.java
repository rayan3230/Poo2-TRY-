package ManagementClasses;

import MainClasses.Cinema;

public class Movie {

    public String Title;
    public Cinema.Genre Genre;
    public float Duration; // in hours
    public String Description;
    public String Director;
    public String Cast;
    public String ReleaseDate;
    public float Rating; // out of 10
    public Cinema.AgeRating AgeRating; // G, PG13, PG16, PG18

    public Movie(String Title, Cinema.Genre Genre, float Duration, String Description, String Director,
            String Cast, String ReleaseDate, float Rating, Cinema.AgeRating AgeRating) {

        this.Title = Title;
        this.Genre = Genre;
        this.Duration = Duration;
        this.Description = Description;
        this.Director = Director;
        this.Cast = Cast;
        this.ReleaseDate = ReleaseDate;
        this.Rating = Rating;
        this.AgeRating = AgeRating;
    }

}
