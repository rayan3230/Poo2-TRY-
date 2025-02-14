package Moodle;

public class Seat {
    public int seatNumber;
    public boolean isAvailable;
    public SeatType type;
    public double price;

    public enum SeatType {
        REGULAR(800),
        VIP(2000);

        public  double basePrice;

        SeatType(double basePrice) {
            this.basePrice = basePrice;
        }
    }

    public Seat(int seatNumber, SeatType type) {
        this.seatNumber = seatNumber;
        this.type = type;
        this.isAvailable = true;
        this.price = type.basePrice;
    }

} 