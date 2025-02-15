package Basic_Classes;

import java.util.ArrayList;


public class Salle {

    private int ID;
    private int capacite;
    ArrayList<Seat> seats;

    public Salle(int ID, int capacite) {
        this.ID = ID;
        this.capacite = capacite;
        this.seats = new ArrayList<>(capacite);
        for (int i = 0; i < capacite; i++) {
            seats.add(new Seat(i, true));
        }
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
        capacite++;
        seats.add(new Seat(capacite, true));
    }

    public void removeSeat(Seat seat) {
        int removedseat = seat.getSeatID();
        seats.remove(seat);
        capacite--;
        for (int i = removedseat; i < capacite; i++) {
            seats.get(i).setSeatID(i);
        }
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public int getID() {
        return ID;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void getAvaibleSeats() {
        for (Seat seat : seats) {
            if (seat.isAvaible()) {
                System.out.println(seat.getSeatID());
            }
        }
    }

    public int getnbrAvaibleSeats() {
        int nbr = 0;
        for (Seat seat : seats) {
            if (seat.isAvaible()) {
                nbr++;
            }
        }
        return nbr;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "ID=" + ID +
                ", capacite=" + capacite +
                ", seats=" + seats +'}';
    }

}
