package Controller;

import Moodle.*;
import Moodle.Movie.genre;
import Moodle.Movie.statusFilm;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class GestionMovie {
    public ArrayList<Movie> Movies = new ArrayList<>();
    public ArrayList<ShowTime> showTimes = new ArrayList<>();
    public int movieCount = 0;
    public int showTimeCount = 0;


    public void addMovie(String Title,String Description, int duration, genre genre, String rating,
        double regularSeatPrice, double vipSeatPrice , String imagepath , statusFilm status , LocalTime ShowTime){
            movieCount++;
            Movie movie = new Movie(Title, Description, duration, genre,rating, regularSeatPrice, vipSeatPrice , imagepath, status , ShowTime);
        
        Movies.add(movie);

    }
    public void addshowTime(int id, Movie movie, Hall hall, LocalDateTime dateTime){
        showTimeCount++;
        ShowTime showTime = new ShowTime(id, movie, hall, dateTime);
        showTimes.add(showTime);
    }
    public void DisplayMovies(){
        for (Movie movie : Movies) {
            System.out.println("Title: " + movie.Title);
            System.out.println("Description: " + movie.description);
            System.out.println("Duration: " + movie.duration);
            System.out.println("Genre: " + movie.genreEnum);
            System.out.println("Rating: " + movie.rating);
            System.out.println("Regular Seat Price: " + movie.regularSeatPrice);
            System.out.println("VIP Seat Price: " + movie.vipSeatPrice);
            System.out.println("Image Path: " + movie.imagePath);
            System.out.println("Status: " + movie.statusfilm);
            System.out.println("Show Time: " + movie.showeTime);
            System.out.println();
        }
    }
}
