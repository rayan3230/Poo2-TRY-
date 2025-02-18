package controll;
import java.util.ArrayList;
import java.util.List;


public class MovieControl {
    private List<String> movies;

    public MovieControl() {
        movies = new ArrayList<>();
    }

    public void addMovie(String movie) {
        movies.add(movie);
    }

    public void modifyMovie(int index, String newMovie) {
        if (index >= 0 && index < movies.size()) {
            movies.set(index, newMovie);
        } else {
            System.out.println("Invalid index");
        }
    }

    public void deleteMovie(int index) {
        if (index >= 0 && index < movies.size()) {
            movies.remove(index);
        } else {
            System.out.println("Invalid index");
        }
    }

    public List<String> getMovies() {
        return new ArrayList<>(movies);
    }
}
