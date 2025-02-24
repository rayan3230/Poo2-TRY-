package Moodle;

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
    public genre genreEnum;

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

    public Movie(String Title,String Description, int duration, genre genre, String rating,
            double regularSeatPrice, double vipSeatPrice , String imagePath, statusFilm status, LocalTime ShowTime) {

            this.id=id+1;
            this.Title = Title;
            this.description = description;
            this.duration = duration;
            this.genreEnum = genre;
            this.rating = rating;
            this.regularSeatPrice = regularSeatPrice;
            this.vipSeatPrice = vipSeatPrice;
            this.imagePath = imagePath;
            this.statusfilm = status;
            this.showeTime = ShowTime;
     }

    // public void printDuration() {
    //     System.out.println("Duration: " + duration);
    // }

}
