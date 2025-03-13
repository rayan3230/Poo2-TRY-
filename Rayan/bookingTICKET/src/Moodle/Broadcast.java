package Moodle;

import java.time.LocalDate;
import java.util.ArrayList;

public class Broadcast {
    public Movie movie;
    public Hall Room;
    public LocalDate Date;
    
    public ArrayList<Ticket> tickets;

    public Broadcast(Movie movie, Hall Room, LocalDate Date) {
        this.movie = movie;
        this.Room = Room;
        this.Date = Date;
        tickets = new ArrayList<>();
    }
}
