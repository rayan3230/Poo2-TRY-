package Moodle;

public class Ticket {

    public String MovieName;
    public int SeatNumber;
    public TypeTicket Type;

    enum TypeTicket{
        VIP,
        Normal
    }

    public Ticket(String movieName, int seatNumber, TypeTicket type) {
        MovieName = movieName;
        SeatNumber = seatNumber;
        Type = type;
    }
    
}
