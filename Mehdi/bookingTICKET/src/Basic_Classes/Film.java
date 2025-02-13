package Basic_Classes;

public class Film {

    private String title;
    private String genre;
    protected int duration;
    private String synopsis;

    enum genre {
        Comédie,
        Drama,
        Thriller,
        Aventure,
        Action, 
        Horreur,
        ScienceFiction,
        Fantastique,
        Animation,
        Musical,
        Documentaire,
        Guerre,
        Western,
        Biopic,
        Romantique,
        Historique,

    }

    public Film(String title, String genre, int duration, String synopsis) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.synopsis = synopsis;
         }

    public String getTitle() {
        return title;
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


    public void setTitle(String title) {
        this.title = title;
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

    

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }
}
