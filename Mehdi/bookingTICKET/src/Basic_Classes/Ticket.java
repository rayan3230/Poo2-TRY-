package Basic_Classes;

public class Ticket {

    private static int ticketcounter = 0;
    private int IDticket;
    private Diffusion diffusion;
    private int seat;
    private double price;
    private String customerID;
    private boolean isAvailable = true;

    public Ticket(Diffusion diffusion, int seat, double price) {
        this.IDticket = ticketcounter + 1;
        this.diffusion = diffusion;
        this.seat = seat;
        this.price = price;
    }

    public int getIDticket() {
        return IDticket;
    }

    public Diffusion getDiffusion() {
        return diffusion;
    }

    public int getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }

    public String getCustomerID() {
        return customerID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIDticket(int IDticket) {
        this.IDticket = IDticket;
    }

    public void setDiffusion(Diffusion diffusion) {
        this.diffusion = diffusion;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "IDticket=" + IDticket +
                ", diffusion=" + diffusion +
                ", seat=" + seat +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }

}
