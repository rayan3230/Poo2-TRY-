package Manageclasses;
public class Movie {

    public enum Genre {
        Action, Comedy, Drama, Horror, Science_Fiction, Thriller, Adventure, Fantasy, Mystery, Romance, Crime,
        Animation, Music, Documentary, Family, Sport, News, Travel, Game, History
    }

    public enum AgeRating {
        PG6, PG8,PG88, PG12
    }

    private String title;
    private Genre genre;
    private float duration;
    private String description;
    private String director;
    private String cast;
    private String releaseDate;
    private float rating;
    private AgeRating ageRating;
    private Theater room;

    public Movie(String title, Genre genre, float duration, String description, String director,
                 String cast, String releaseDate, float rating, AgeRating ageRating, Theater room) {
        setTitle(title);
        setGenre(genre);
        setDuration(duration);
        setDescription(description);
        setDirector(director);
        setCast(cast);
        setReleaseDate(releaseDate);
        setRating(rating);
        setAgeRating(ageRating);
        setRoom(room);
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public float getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public String getCast() {
        return cast;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public float getRating() {
        return rating;
    }

    public AgeRating getAgeRating() {
        return ageRating;
    }

    public Theater getRoom() {
        return room;
    }

    public void setTitle(String title) {
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        }
    }

    public void setGenre(Genre genre) {
        if (genre != null) {
            this.genre = genre;
        }
    }

    public void setDuration(float duration) {
        if (duration > 0) {
            this.duration = duration;
        }
    }

    public void setDescription(String description) {
        this.description = (description != null) ? description : "Aucune description disponible.";
    }

    public void setDirector(String director) {
        this.director = (director != null) ? director : "Inconnu";
    }

    public void setCast(String cast) {
        this.cast = (cast != null) ? cast : "Non spécifié";
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = (releaseDate != null) ? releaseDate : "Date inconnue";
    }

    public void setRating(float rating) {
        if (rating >= 0 && rating <= 10) {
            this.rating = rating;
        }
    }

    public void setAgeRating(AgeRating ageRating) {
        if (ageRating != null) {
            this.ageRating = ageRating;
        }
    }

    public void setRoom(Theater room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Film : " + title + "\n" +
               "Genre : " + genre + "\n" +
               " Durée : " + duration + " heures\n" +
               " Description : " + description + "\n" +
               " Réalisateur : " + director + "\n" +
               " Casting : " + cast + "\n" +
               " Date de sortie : " + releaseDate + "\n" +
               "Note : " + rating + "/10\n" +
               " Classification d'âge : " + ageRating + "\n" +
               " Salle : " + (room != null ? room.getName() : "Non attribuée");
    }
}

