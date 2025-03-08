package controller;

import Model.*;
import java.util.ArrayList;

public class BookingManager {

    public MovieManager movieManager;
    public TheaterManager theaterManager;
    public BroadcastManager broadcastManager;
    public ClientManager clientManager;

    public ArrayList<Ticket> bookedTicket;

    public BookingManager() {
        movieManager = new MovieManager();
        theaterManager = new TheaterManager();
        broadcastManager = new BroadcastManager();
        clientManager = new ClientManager();
        
        bookedTicket = new ArrayList<>();
    }

    public void BookTicket(Client client, Seats Seat, Broadcast broadcast, Ticket.TicketType Type) {
        Ticket ticket = new Ticket(Seat, Type, broadcast);
        ticket.Buyer = client;
        bookedTicket.add(ticket);
        broadcast.tickets.remove(ticket);
    }




}
