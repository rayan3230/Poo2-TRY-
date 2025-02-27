package moodle;
import controller.Booking;
import java.time.LocalDateTime;

public class Payment {
    public int id;
    public Booking booking;
    public double amount;
    public PaymentType paymentMethod;
    public LocalDateTime paymentTime;
    public TypeStatus status;

    
    public enum PaymentType {
        CREDIT_CARD,
        Cash,
    }

    public enum TypeStatus{
        PENDING,
        PAID,
        CANCELLED
    }

    public Payment(int id, Booking booking, PaymentType paymentMethod ,TypeStatus status ) {
        this.id = id;
        this.booking = booking;
        this.amount = booking.totalPrice;
        this.paymentMethod = paymentMethod;
        this.paymentTime = LocalDateTime.now();
        this.status = status;
    }
} 
