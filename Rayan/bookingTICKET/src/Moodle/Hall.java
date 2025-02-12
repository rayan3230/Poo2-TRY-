package Moodle;

import java.util.ArrayList;

public class Hall {
    public int id = 0;
    public String NameHall;
    public int seat, VipSeat;
    ArrayList<Integer> NbrSeat;
    
    public Hall(int id, String nameHall, int seat, int VipSeat) {
        this.id = id + 1;
        this.NameHall = nameHall;
        this.seat = seat;
        this.VipSeat = VipSeat;
        this.NbrSeat = new ArrayList<>(seat + VipSeat);
    }
}
