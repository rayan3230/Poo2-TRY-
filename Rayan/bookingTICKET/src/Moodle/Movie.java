package Moodle;

import java.time.LocalDate;
import java.time.LocalTime;

public  class  Movie {
    public int id =0;//
    public String Title;//
    public String description;//
    public int duration; // in minutes
    public String rating;
    public LocalTime showeTime;
    public double regularSeatPrice;
    public double vipSeatPrice;
    public String imagePath;
    public statusFilm statusfilm;
    public genre MovieGenre;
    public LocalDate ReleaseDate;
    public MovieAgeRating AgeRating;

    public enum genre {
        COMEDY,
        ACTION,
        DRAMA,
        ROMANCE
    }
    public enum statusFilm{
        AVAILABLE,
        SOLD_OUT,
        UPCOMING
    }

    public enum MovieAgeRating {
        G, PG6, PG8, PG13, PG16, PG18
    }

    public Movie(String Title,String Description, int duration, genre genre, String rating,
            double regularSeatPrice, double vipSeatPrice , String imagePath ,statusFilm status,  LocalDate ReleaseDate ,LocalTime ShowTime ,MovieAgeRating AgeRating) {

            this.id=id+1;
            this.Title = Title;
            this.description = description;
            this.duration = duration;
            this.MovieGenre = genre;
            this.rating = rating;
            this.regularSeatPrice = regularSeatPrice;
            this.vipSeatPrice = vipSeatPrice;
            this.imagePath = imagePath;
            this.statusfilm = status;
            this.showeTime = ShowTime;
            this.ReleaseDate = ReleaseDate;
            this.AgeRating = AgeRating;
     }

    // public void printDuration() {
    //     System.out.println("Duration: " + duration);
    // }

}
