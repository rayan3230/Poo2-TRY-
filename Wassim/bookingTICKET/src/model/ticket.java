package model;

public class ticket {
    private String movieName;
    private String cinemaHall;
    private String seatNumber;
    private String showTime;
    private double price;

    public ticket(String movieName, String cinemaHall, String seatNumber, String showTime, double price) {
        this.movieName = movieName;
        this.cinemaHall = cinemaHall;
        this.seatNumber = seatNumber;
        this.showTime = showTime;
        this.price = price;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(String cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "movieName='" + movieName + '\'' +
                ", cinemaHall='" + cinemaHall + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", showTime='" + showTime + '\'' +
                ", price=" + price +
                '}';
    }
}