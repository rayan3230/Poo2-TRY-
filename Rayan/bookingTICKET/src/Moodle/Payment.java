package Moodle;

import java.time.LocalDateTime;

public class Payment {
    public int id;
    public Booking booking;
    public double amount;
    public String paymentMethod;
    public LocalDateTime paymentTime;
    public String status;

    public Payment(int id, Booking booking, String paymentMethod) {
        this.id = id;
        this.booking = booking;
        this.amount = booking.totalPrice;
        this.paymentMethod = paymentMethod;
        this.paymentTime = LocalDateTime.now();
        this.status = "PENDING";
    }
} 