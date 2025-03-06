package controller;

import java.util.ArrayList;
import Model.*;

public class TheaterManager {

    public ArrayList<Theater> theaters;

    public TheaterManager() {

        this.theaters = new ArrayList<Theater>();

        Theater Room1 = new Theater(0, 200, 40, 1, true);
        Theater Room2 = new Theater(1, 300, 60, 2, true);
        Theater Room3 = new Theater(2, 400, 80, 3, true);
        Theater Room4 = new Theater(3, 200, 40, 4, true);
        Theater Room5 = new Theater(4, 300, 60, 5, true);
        Theater Room6 = new Theater(5, 200, 40, 6, true);
        Theater Room7 = new Theater(6, 200, 40, 7, true);

        AddTheater(Room1);
        AddTheater(Room2);
        AddTheater(Room3);
        AddTheater(Room4);
        AddTheater(Room5);
        AddTheater(Room6);
        AddTheater(Room7);
    }

    public void AddTheater(Theater theater) {
        theaters.add(theater);
    }

}
