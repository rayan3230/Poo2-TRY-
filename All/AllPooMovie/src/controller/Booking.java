package controller;

import java.time.LocalDateTime;

import Model.Account;
import Model.Seats;

public class Booking {
    public int id;
    public Account customer;
    public Broadcast showTime;
    public Seats seat;
    public LocalDateTime bookingTime;
    public double totalPrice;
    public BookingStatus status; 

    public enum BookingStatus{
        CONFIRMED,
        CANCELLED, 
        PENDING;
    }

    public Booking(int id, Account customer, Broadcast showTime, Seats seat ,BookingStatus Status) {
        this.id = id;
        this.customer = customer;
        this.showTime = showTime;
        this.seat = seat;
        this.bookingTime = LocalDateTime.now();// t3tik lw9t ta3 dok wa9il
        this.totalPrice = seat.price;
        this.status = Status;
    }
} 