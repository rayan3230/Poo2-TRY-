package controll;

public class AdminController {
    


    public void listclient() {
        // Logic to list all admins
        System.out.println("Listing all admins...");
    }

    public void addMovie(String movieName) {
        // Logic to add a movie
        System.out.println("Movie added: " + movieName);
    }

    public void removeMovie(String movieName) {
        // Logic to remove a movie
        System.out.println("Movie removed: " + movieName);
    }

    public void modifyMovie(String movieName, String newDetails) {
        // Logic to modify a movie
        System.out.println("Movie modified: " + movieName + " with new details: " + newDetails);
    }

    public void seeUsers() {
        // Logic to see all users
        System.out.println("Listing all users...");
    }

    public void seeTheaters() {
        // Logic to see all theaters
        System.out.println("Listing all theaters...");
    }

    public void seeSeats(String theaterName) {
        // Logic to see all seats in a theater
        System.out.println("Listing all seats in theater: " + theaterName);
    }

    public void seeUpcomingBookings() {
        // Logic to see all upcoming bookings
        System.out.println("Listing all upcoming bookings...");
    }

    public void seePlans() {
        // Logic to see all plans
        System.out.println("Listing all plans...");
    }
}
