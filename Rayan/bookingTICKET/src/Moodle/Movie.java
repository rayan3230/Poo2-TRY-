package Moodle;

import java.time.LocalTime;

public class Movie {
    public int id;
    public String Title;
    public String description;
    public int duration; // in minutes
    public String genre;
    public String rating;
    public LocalTime showeTime;
    public double regularSeatPrice;
    public double vipSeatPrice;
   
    // Added field for genre
    public genre genreEnum;

    enum genre {
        ACTION,
        COMEDY,
        DRAMA,
        ROMANCE;
    }

    public Movie(String Title,String Description, int duration, String genre, String rating,
            double regularSeatPrice, double vipSeatPrice) {

            this.id = id;
            this.Title = Title;
            this.description = description;
            this.duration = duration;
            this.genre = genre;
            this.rating = rating;
            this.regularSeatPrice = regularSeatPrice;
            this.vipSeatPrice = vipSeatPrice;
     }

    // public void printDuration() {
    //     System.out.println("Duration: " + duration);
    // }

}
