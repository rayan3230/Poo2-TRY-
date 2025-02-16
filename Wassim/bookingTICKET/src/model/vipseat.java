package model;

public class vipseat {
    private String seatNumber;
    private boolean isReserved;

    public vipseat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.isReserved = false;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserveSeat() {
        if (!isReserved) {
            isReserved = true;
        } else {
            System.out.println("Seat is already reserved.");
        }
    }

    public void cancelReservation() {
        if (isReserved) {
            isReserved = false;
        } else {
            System.out.println("Seat is not reserved.");
        }
    }
}
