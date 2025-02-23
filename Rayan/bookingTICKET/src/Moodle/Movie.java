package Moodle;

import java.time.LocalTime;

public class Movie {
    public int id =0;
    public String Title;
    public String description;
    public int duration; // in minutes
    public String genre;
    public String rating;
    public LocalTime showeTime;
    public double regularSeatPrice;
    public double vipSeatPrice;
    public String imagePath;
    public String status;
   
    // Added field for genre
    public genre genreEnum;

    enum genre {
        ACTION,
        COMEDY,
        DRAMA,
        ROMANCE;
    }

    public Movie(String Title,String Description, int duration, String genre, String rating,
            double regularSeatPrice, double vipSeatPrice , String imagePath, String status) {

            this.id=id+1;
            this.Title = Title;
            this.description = description;
            this.duration = duration;
            this.genre = genre;
            this.rating = rating;
            this.regularSeatPrice = regularSeatPrice;
            this.vipSeatPrice = vipSeatPrice;
            this.imagePath = imagePath;
            this.status = status;
     }

    // public void printDuration() {
    //     System.out.println("Duration: " + duration);
    // }

}
