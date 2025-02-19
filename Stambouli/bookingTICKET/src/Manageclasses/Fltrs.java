package Manageclasses;
import java.util.Arrays;

public class Fltrs {
    public enum Genre {
        Action, Adventure, Comedy, Drama, Fantasy, Horror, Mystery, Romance, Thriller, NULL
    }

    public enum AgeRestriction {
         PG29, PG88, NULL
    }

    public enum TicketType {
        VIP, Normal, NULL
    }

    private Genre genre = Genre.NULL;
    private AgeRestriction ageRestriction = AgeRestriction.NULL;
    private float duration = 0f;
    private int rating = 0;
    private String date = "NULL";
    private TicketType ticketType = TicketType.NULL;
    private String releaseDate = "NULL";
    private int[] seats = {0, 0};
    private String name = "NULL";

    public Fltrs() {}

    public Genre getGenre() {
        return genre;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public float getDuration() {
        return duration;
    }

    public int getRating() {
        return rating;
    }

    public String getDate() {
        return date;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int[] getSeats() {
        return seats;
    }

    public String getName() {
        return name;
    }

    public void setGenre(Genre genre) {
        this.genre = (genre != null) ? genre : Genre.NULL;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = (ageRestriction != null) ? ageRestriction : AgeRestriction.NULL;
    }

    public void setDuration(float duration) {
        if (duration > 0) {
            this.duration = duration;
        } else {
            System.out.println("Erreur : La durée doit être positive.");
        }
    }

    public void setRating(int rating) {
        if (rating >= 0 && rating <= 10) {
            this.rating = rating;
        } else {
            System.out.println("Erreur : La note doit être entre 0 et 10.");
        }
    }

    public void setDate(String date) {
        if (date != null && !date.isEmpty()) {
            this.date = date;
        } else {
            System.out.println("Erreur : Date invalide.");
        }
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = (ticketType != null) ? ticketType : TicketType.NULL;
    }

    public void setReleaseDate(String releaseDate) {
        if (releaseDate != null && !releaseDate.isEmpty()) {
            this.releaseDate = releaseDate;
        } else {
            System.out.println("Erreur : Date de sortie invalide.");
        }
    }

    public void setSeats(int[] seats) {
        if (seats != null && seats.length == 2 && seats[0] >= 0 && seats[1] >= 0) {
            this.seats = seats;
        } else {
            System.out.println("Erreur : Les sièges doivent contenir 2 valeurs positives.");
        }
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Erreur : Le nom du film ne peut pas être vide.");
        }
    }

    public void displayFilters() {
        System.out.println("🎬 Filtres sélectionnés :");
        System.out.println("🔹 Genre : " + genre);
        System.out.println("🔹 Restriction d'âge : " + ageRestriction);
        System.out.println("🔹 Durée : " + duration + " minutes");
        System.out.println("🔹 Note : " + rating + "/10");
        System.out.println("🔹 Date de diffusion : " + date);
        System.out.println("🔹 Type de ticket : " + ticketType);
        System.out.println("🔹 Date de sortie : " + releaseDate);
        System.out.println("🔹 Sièges : " + Arrays.toString(seats));
        System.out.println("🔹 Nom du film : " + name);
    }
}
