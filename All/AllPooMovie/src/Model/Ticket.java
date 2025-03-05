package Model;

public class Ticket {
    public int number;
    public TicketType Type; // VIP, Normal
    public Broadcast broadcast;

    public enum TicketType{
        VIP, Normal
    }

    public Ticket(int number, TicketType Type, Broadcast broadcast) {

        this.number = number;
        this.Type = Type;
        this.broadcast = broadcast;
    }
}
