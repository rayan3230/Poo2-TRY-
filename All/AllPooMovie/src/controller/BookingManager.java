package controller;

import Model.*;
import java.util.ArrayList;
import javax.sql.rowset.RowSetMetaDataImpl;

public class BookingManager {

    public MovieManager movieManager;
    public TheaterManager theaterManager;
    public BroadcastManager broadcastManager;
    public ClientManager clientManager;

    public ArrayList<Ticket> bookedTicket;

    public BookingManager() {
        bookedTicket = new ArrayList<>();
    }

    public void BookTicket(Client client, int TicketNumber, Broadcast broadcast, Ticket.TicketType Type) {
        Ticket ticket = new Ticket(TicketNumber, Type, broadcast);
        ticket.Buyer = client;
        bookedTicket.add(ticket);
        broadcast.tickets.remove(ticket);
    }




}
