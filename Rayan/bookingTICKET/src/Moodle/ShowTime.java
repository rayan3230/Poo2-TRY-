package Moodle;

import java.time.LocalDateTime;

public class ShowTime {
    public int id;
    public Movie movie;
    public Hall hall;
    public LocalDateTime dateTime;

    public ShowTime(int id, Movie movie, Hall hall, LocalDateTime dateTime) {
        this.id = id;
        this.movie = movie;
        this.hall = hall;
        this.dateTime = dateTime;
    }

}
