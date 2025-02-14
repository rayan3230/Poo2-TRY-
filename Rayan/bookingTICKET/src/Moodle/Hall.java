package Moodle;

import java.util.ArrayList;
import java.util.List;

public class Hall {
    public int id = 0;
    public String NameHall;
    public int totalVipSeats, totalRegularSeats;
    public List<Seat> seats;
    public boolean vipSeatsAvailable , regularSeatsAvailable;
    public boolean HallAvailable;
    
    public Hall(int id , String NameHall, int totalRegularSeats , int totalVipSeats ) {
        this.id = id;
        this.NameHall = NameHall;
        this.totalRegularSeats = totalRegularSeats;
        this.totalVipSeats = totalVipSeats;
        this.vipSeatsAvailable = true;
        this.regularSeatsAvailable = true;
        this.HallAvailable = true;
        initisSeats(totalRegularSeats, totalVipSeats);
    }

    public void initisSeats(int regularSeats, int vipSeats) {
        seats = new ArrayList<>();
        
        for (int i = 1; i <= regularSeats; i++) {
            seats.add(new Seat(i, Seat.SeatType.REGULAR));
        }

        for (int i = regularSeats + 1; i <= regularSeats + vipSeats; i++) {
            seats.add(new Seat(i, Seat.SeatType.VIP));
        }
    }
    public boolean cancelReservation(int seatNumber) {
        for (Seat seat : seats) {
            if (seat.seatNumber == seatNumber && !seat.isAvailable) {
                seat.isAvailable = true;
                return true;
            }
        }
        return false;
    }
    public boolean isSeatAvailable(int seatNumber) {
        for (Seat seat : seats) {
            if (seat.seatNumber == seatNumber) {
                return seat.isAvailable;
            }
        }
        return false;
    }
}
