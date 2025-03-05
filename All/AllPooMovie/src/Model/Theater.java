package Model;

import java.util.ArrayList;

public class Theater {
    public int TheaterId;
    
    public int NormalCapacity;
    public int VipCapacity;

    public Boolean isAvailable;
    public int TotalPlaces;
    
    public int NormalReservedPlaces = 0;
    public int VipReservedPlaces = 0;

    public ArrayList<Seats> NormalSeats = new ArrayList<Seats>();
    public ArrayList<Seats> VipSeats = new ArrayList<Seats>();

    public Theater(int NormalCapacity, int VipCapacity, int TheaterId, Boolean Available) {
        this.NormalCapacity = NormalCapacity;
        this.TheaterId = TheaterId;
        this.VipCapacity = VipCapacity;
        this.isAvailable = Available;
        this.TotalPlaces = NormalCapacity + VipCapacity;
    }


}
