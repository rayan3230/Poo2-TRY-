package Controller;

import Moodle.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class GestionMovie {
    public ArrayList<Movie> Movies = new ArrayList<>();
    public ArrayList<ShowTime> showTimes = new ArrayList<>();
    public int movieCount = 0;
    public int showTimeCount = 0;


    public void addMovie(String Title,String Description, int duration, String genre, String rating,
        double regularSeatPrice, double vipSeatPrice){
            movieCount++;
            Movie movie = new Movie(Title, Description, duration, genre,rating, regularSeatPrice, vipSeatPrice);
        
        Movies.add(movie);

    }
    public void addshowTime(int id, Movie movie, Hall hall, LocalDateTime dateTime){
        showTimeCount++;
        ShowTime showTime = new ShowTime(id, movie, hall, dateTime);
        showTimes.add(showTime);
    }
}
