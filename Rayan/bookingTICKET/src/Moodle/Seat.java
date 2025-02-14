package Moodle;

public class Seat {
    public int seatNumber;
    public boolean isAvailable;
    public SeatType type;
    public double price;

    public enum SeatType {
        REGULAR,
        VIP;
    }

    public Seat(int seatNumber, SeatType type) {
        this.seatNumber = seatNumber;
        this.type = type;
        this.isAvailable = true;
    }

} 