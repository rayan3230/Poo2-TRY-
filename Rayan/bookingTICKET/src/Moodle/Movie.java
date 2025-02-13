package Moodle;

import java.time.LocalTime;

public class Movie {
    public String name;
    public LocalTime duration = LocalTime.of(12, 12, 0, 0);
    public ShoweTime showeTime;
    // Added field for genre
    public genre genre;

    enum genre {
        ACTION,
        COMEDY,
        DRAMA,
        ROMANCE;
    }

    public Movie(String name, LocalTime duration, genre genre , ShoweTime showeTime) {
        this.name = name;
        this.duration = duration;
        this.genre = genre;
        this.showeTime = showeTime;
    }

    // public void printDuration() {
    //     System.out.println("Duration: " + duration);
    // }

}
