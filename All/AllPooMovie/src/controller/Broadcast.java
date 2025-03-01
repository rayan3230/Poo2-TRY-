package controller;

import java.time.LocalDate;

import Model.*;

public class Broadcast {
    public Movie movie;
    public Theater Room;
    public LocalDate Date;

    public Broadcast(Movie movie, Theater Room, LocalDate Date) {
        this.movie = movie;
        this.Room = Room;
        this.Date = Date;
    }
    
}
