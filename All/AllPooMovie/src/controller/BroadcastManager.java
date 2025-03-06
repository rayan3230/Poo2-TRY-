package controller;

import Model.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class BroadcastManager {

    public MovieManager movieManager;
    public TheaterManager theaterManager;
    public ArrayList<Broadcast> broadcasts;


    public BroadcastManager() {
        broadcasts = new ArrayList<Broadcast>();
    
        Broadcast Broadcast1 = new Broadcast(movieManager.movies.get(0), theaterManager.theaters.get(0), LocalDate.of(2025, 3, 1));
        Broadcast Broadcast24 = new Broadcast(movieManager.movies.get(1), theaterManager.theaters.get(2), LocalDate.of(2025, 10, 20));
        Broadcast Broadcast2 = new Broadcast(movieManager.movies.get(2), theaterManager.theaters.get(1), LocalDate.of(2025, 3, 10));
        Broadcast Broadcast3 = new Broadcast(movieManager.movies.get(3), theaterManager.theaters.get(2), LocalDate.of(2025, 3, 20));
        Broadcast Broadcast4 = new Broadcast(movieManager.movies.get(4), theaterManager.theaters.get(3), LocalDate.of(2025, 5, 5));
        Broadcast Broadcast5 = new Broadcast(movieManager.movies.get(4), theaterManager.theaters.get(4), LocalDate.of(2025, 5, 15));
        Broadcast Broadcast6 = new Broadcast(movieManager.movies.get(6), theaterManager.theaters.get(5), LocalDate.of(2025, 5, 25));
        Broadcast Broadcast7 = new Broadcast(movieManager.movies.get(7), theaterManager.theaters.get(6), LocalDate.of(2025, 4, 10));
        Broadcast Broadcast8 = new Broadcast(movieManager.movies.get(8), theaterManager.theaters.get(0), LocalDate.of(2025, 5, 30));
        Broadcast Broadcast9 = new Broadcast(movieManager.movies.get(9), theaterManager.theaters.get(1), LocalDate.of(2025, 4, 20));
        Broadcast Broadcast10 = new Broadcast(movieManager.movies.get(10), theaterManager.theaters.get(2), LocalDate.of(2025, 6, 1));
        Broadcast Broadcast11 = new Broadcast(movieManager.movies.get(11), theaterManager.theaters.get(3), LocalDate.of(2025, 6, 10));
        Broadcast Broadcast12 = new Broadcast(movieManager.movies.get(12), theaterManager.theaters.get(4), LocalDate.of(2025, 6, 20));
        Broadcast Broadcast13 = new Broadcast(movieManager.movies.get(13), theaterManager.theaters.get(5), LocalDate.of(2025, 7, 1));
        Broadcast Broadcast14 = new Broadcast(movieManager.movies.get(14), theaterManager.theaters.get(6), LocalDate.of(2025, 7, 10));
        Broadcast Broadcast15 = new Broadcast(movieManager.movies.get(15), theaterManager.theaters.get(0), LocalDate.of(2025, 7, 20));
        Broadcast Broadcast16 = new Broadcast(movieManager.movies.get(16), theaterManager.theaters.get(1), LocalDate.of(2025, 8, 1));
        Broadcast Broadcast17 = new Broadcast(movieManager.movies.get(17), theaterManager.theaters.get(3), LocalDate.of(2025, 8, 10));
        Broadcast Broadcast18 = new Broadcast(movieManager.movies.get(18), theaterManager.theaters.get(3), LocalDate.of(2025, 8, 20));
        Broadcast Broadcast19 = new Broadcast(movieManager.movies.get(19), theaterManager.theaters.get(4), LocalDate.of(2025, 9, 1));
        Broadcast Broadcast20 = new Broadcast(movieManager.movies.get(20), theaterManager.theaters.get(5), LocalDate.of(2025, 9, 10));
        Broadcast Broadcast21 = new Broadcast(movieManager.movies.get(21), theaterManager.theaters.get(6), LocalDate.of(2025, 9, 20));
        Broadcast Broadcast22 = new Broadcast(movieManager.movies.get(22), theaterManager.theaters.get(0), LocalDate.of(2025, 10, 1));
        Broadcast Broadcast23 = new Broadcast(movieManager.movies.get(23), theaterManager.theaters.get(1), LocalDate.of(2025, 10, 10));

        addBroadcast(Broadcast1);
        addBroadcast(Broadcast2);
        addBroadcast(Broadcast3);
        addBroadcast(Broadcast4);
        addBroadcast(Broadcast5);
        addBroadcast(Broadcast6);
        addBroadcast(Broadcast7);
        addBroadcast(Broadcast8);
        addBroadcast(Broadcast9);
        addBroadcast(Broadcast10);
        addBroadcast(Broadcast11);
        addBroadcast(Broadcast12);
        addBroadcast(Broadcast13);
        addBroadcast(Broadcast14);
        addBroadcast(Broadcast15);
        addBroadcast(Broadcast16);
        addBroadcast(Broadcast17);
        addBroadcast(Broadcast18);
        addBroadcast(Broadcast19);
        addBroadcast(Broadcast20);
        addBroadcast(Broadcast21);
        addBroadcast(Broadcast22);
        addBroadcast(Broadcast23);
        addBroadcast(Broadcast24);
    }

    
    public void addBroadcast(Broadcast broadcast) {
        broadcasts.add(broadcast);
    }


}
