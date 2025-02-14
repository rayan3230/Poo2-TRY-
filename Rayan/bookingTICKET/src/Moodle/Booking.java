package Moodle;

import java.time.LocalDateTime;

public class Booking {
    public int id;
    public Accounts customer;
    public ShowTime showTime;
    public Seat seat;
    public LocalDateTime bookingTime;
    public double totalPrice;
    public BookingStatus status; 

    public enum BookingStatus{
        CONFIRMED,
        CANCELLED, 
        PENDING;
    }

    public Booking(int id, Accounts customer, ShowTime showTime, Seat seat ,BookingStatus Status) {
        this.id = id;
        this.customer = customer;
        this.showTime = showTime;
        this.seat = seat;
        this.bookingTime = LocalDateTime.now();// t3tik lw9t ta3 dok wa9il
        this.totalPrice = seat.price;
        this.status = Status;
    }
} 