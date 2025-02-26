package moodle;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    
    public int TheaterId;
    public int NormalCapacity;
    public int VipCapacity;
    public Boolean Available;

    public int TotalPlaces;
    public int NormalReservedPlaces = 0;
    public int VipReservedPlaces = 0;

    public List<Seats> seats;

    public Theater(int NormalCapacity, int VipCapacity, int TheaterId, Boolean Available) {
        this.NormalCapacity = NormalCapacity;
        this.TheaterId = TheaterId;
        this.VipCapacity = VipCapacity;
        this.Available = Available;
        
        seats = new ArrayList<>();

        this.TotalPlaces = NormalCapacity + VipCapacity;
    }

    public void initisSeats(int regularSeats, int vipSeats) {
        for (int i = 1; i <= vipSeats; i++) {
            seats.add(new Seats(i, Seats.SeatType.VIP));
        }

        for (int i = vipSeats + 1; i <= regularSeats + vipSeats; i++) {
            seats.add(new Seats(i, Seats.SeatType.REGULAR));
        }
    }

    public boolean cancelReservation(int seatNumber) {
        for (Seats seat : seats) {
            if (seat.seatNumber == seatNumber && !seat.isAvailable) {
                seat.isAvailable = true;
                return true;
            }
        }
        return false;
    }

    public boolean isSeatAvailable(int seatNumber) {
        for (Seats seat : seats) {
            if (seat.seatNumber == seatNumber) {
                return seat.isAvailable;
            }
        }
        return false;
    }

}
