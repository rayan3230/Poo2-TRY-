package Basic_Classes;

public class Seat {

    private int seatID;
    private boolean isAvaible = true;

    public Seat(int seatID, boolean isAvaible) {
        this.seatID = seatID;
        this.isAvaible = isAvaible;
    }

    public int getSeatID() {
        return seatID;
    }

    public boolean isAvaible() {
        return isAvaible;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public void Reserveseat(int seatID) {
        this.isAvaible = false;
    }

}
