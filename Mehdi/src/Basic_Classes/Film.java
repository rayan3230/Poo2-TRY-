package Basic_Classes;

public class Film {

    private String title;
    private String director;
    private String genre;
    private String language;
    protected int duration;
    private String synopsis;
    private String AgeRestriction;

    enum AgeRestriction {
        For_ALL,
        Under_10,
        Under_12,
        Under_16,
        Under_18,

    } 

    enum language{
        VOSTFR,
        VF,
        VOSTEN,
        VO,
    }

    enum genre {
        Comedy,
        Drama,
        Thriller,
        Aventure,
        Action, 
        Horror,
        ScienceFiction,
        Fantastic,
        Animation,
        Musical,
        Documentary,
        War,
        Western,
        Biopic,
        Romantic,
        Historic,

    }

    public Film(String title, String director, String genre, int duration, String synopsis, String AgeRestriction, String language) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.duration = duration;
        this.synopsis = synopsis;
        this.AgeRestriction = AgeRestriction;
        this.language = language;
        }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public String getsynopsis() {
        return synopsis;
    }

    public String getAgeRestriction() {
        return AgeRestriction;
    }

    public String getLanguage() {
        return language;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setsynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setAgeRestriction(String AgeRestriction) {
        this.AgeRestriction = AgeRestriction;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    

    @Override
    public String toString() {
        return "Film{" +
                "Title='" + title + '\'' +
                ", Genre='" + genre + '\'' +
                ", Duration=" + duration +
                ", Synopsis='" + synopsis + '\'' +
                ", AgeRestriction='" + AgeRestriction + '\'' +
                '}';
    }
}
