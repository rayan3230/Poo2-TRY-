package controll;

import java.util.ArrayList;
import java.util.List;

public class booking {
    public class Booking {
        private int totalSeats;
        private List<Integer> bookedSeats;

        public Booking(int totalSeats) {
            this.totalSeats = totalSeats;
            this.bookedSeats = new ArrayList<>();
        }

        public boolean bookSeat(int seatNumber) {
            if (seatNumber < 1 || seatNumber > totalSeats) {
                System.out.println("Invalid seat number.");
                return false;
            }
            if (bookedSeats.contains(seatNumber)) {
                System.out.println("Seat already booked.");
                return false;
            }
            if (bookedSeats.size() >= totalSeats) {
                System.out.println("Theater is full.");
                return false;
            }
            bookedSeats.add(seatNumber);
            System.out.println("Seat " + seatNumber + " successfully booked.");
            return true;
        }

        public boolean cancelBooking(int seatNumber) {
            if (bookedSeats.contains(seatNumber)) {
                bookedSeats.remove(Integer.valueOf(seatNumber));
                System.out.println("Booking for seat " + seatNumber + " cancelled.");
                return true;
            } else {
                System.out.println("Seat not booked yet.");
                return false;
            }
        }

        public void displayAvailableSeats() {
            System.out.println("Available seats:");
            for (int i = 1; i <= totalSeats; i++) {
                if (!bookedSeats.contains(i)) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
}
