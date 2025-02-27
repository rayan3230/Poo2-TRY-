package moodle;

import java.time.LocalTime;

public class Movie {
    
    public int id =0;
    public String Title;
    public MovieGenre Genre;
    public float Duration; // in hours
    public String Description;
    public String Director;
    public String Cast;
    public String ReleaseDate;
    public LocalTime showeTime;
    public float Rating; // out of 10
    public AgeRating AgeRating; // G, PG13, PG16, PG18
    public Theater Room;
    public double regularSeatPrice;
    public double vipSeatPrice;
    public language MovieLanguage;
    public statusFilm statusfilm;
    public String ImagePath;
    public Boolean SensetiveContente;
    


    public enum MovieGenre {
        Action, Comedy, Drama, Horor, Science_Fiction, Thriller, Adventure, Fantasy, Mystery, Romance, Crime,
        Animation, Music, Documentary, Family, Sport, News, Travel, Game, History

    }
    public enum language{
        VOSTFR,
        VF,
        VOSTEN,
        VO,
    }

    public enum AgeRating {
        G, PG6, PG8, PG13, PG16, PG18
    }
    public enum statusFilm{
        AVAILABLE,
        SOLD_OUT,
        UPCOMING
    }

    public Movie(String Title, MovieGenre Genre, float Duration, String Description, String Director,
            String Cast, String ReleaseDate, float Rating, AgeRating AgeRating, Theater Room , language MovieLanguage ,
                 double regularSeatPrice , double vipSeatPrice , String ImagePath , statusFilm status , LocalTime ShowTime) {

        this.id = id+1;
        this.Title = Title;
        this.Genre = Genre;
        this.Duration = Duration;
        this.Description = Description;
        this.Director = Director;
        this.Cast = Cast;
        this.ReleaseDate = ReleaseDate;
        this.Rating = Rating;
        this.AgeRating = AgeRating;
        this.MovieLanguage = MovieLanguage;
        this.regularSeatPrice = regularSeatPrice;
        this.vipSeatPrice = vipSeatPrice;
        this.ImagePath = ImagePath;
        this.statusfilm = status;
        this.showeTime = ShowTime;
        this.Room = Room;
        if(this.AgeRating == AgeRating.PG18){
            this.SensetiveContente = true;
        }else{
            this.SensetiveContente = false;
        }
        if(this.Genre == MovieGenre.Horor||this.Genre == MovieGenre.Thriller || this.Genre == MovieGenre.Action){
            this.SensetiveContente = true;

        }
    }

}
