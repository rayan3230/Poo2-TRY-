package ManagementClasses;

import MainClasses.Cinema;

public class Ticket {

    public int number;
    public Cinema.TicketType Type; // VIP, Normal
    public Broadcast broadcast;

    public Ticket(int number, Cinema.TicketType Type, Broadcast broadcast) {

        this.number = number;
        this.Type = Type;
        this.broadcast = broadcast;
    }

}
