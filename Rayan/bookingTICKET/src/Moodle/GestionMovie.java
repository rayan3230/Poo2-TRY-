package Moodle;

import java.util.ArrayList;

public class GestionMovie {
    ArrayList<ShoweTime> showeTimeList = new ArrayList<>();

    public GestionMovie(ArrayList<ShoweTime> showeTimeList) {
        this.showeTimeList = showeTimeList;
    }

    public void addShowTime(ShoweTime showeTime) {
        showeTimeList.add(showeTime);
    }

    public void removeShowtime(ShoweTime showeTime) {
        showeTimeList.remove(showeTime);
    }
}
