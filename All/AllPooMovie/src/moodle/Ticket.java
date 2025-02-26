package moodle;

import controller.Broadcast;

public class Ticket {

    public int number;
    public String Type; // VIP, Normal
    public Broadcast broadcast;

    enum Type {
        VIP, Normal
    }

    public Ticket(int number, String Type, Broadcast broadcast) {

        this.number = number;
        this.Type = Type;
        this.broadcast = broadcast;
    }

}
