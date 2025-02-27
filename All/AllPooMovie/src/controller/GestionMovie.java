package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import moodle.*;
import moodle.Movie.AgeRating;
import moodle.Movie.MovieGenre;
import moodle.Movie.language;
import moodle.Movie.statusFilm;




public class GestionMovie {
    public ArrayList<Movie> Movies = new ArrayList<>();
    public ArrayList<Broadcast> showTimes = new ArrayList<>();
    public int showTimeCount = 0;

    public GestionMovie() {
    }

    public void addMovie(String Title, MovieGenre Genre, float Duration, String Description, String Director,
            String Cast, String ReleaseDate, float Rating, AgeRating AgeRating, Theater Room , language MovieLanguage ,
                 double regularSeatPrice , double vipSeatPrice , String ImagePath , statusFilm status , LocalTime ShowTime){

        Movie movie = new Movie( Title,  Genre,  Duration,  Description,  Director,Cast,  ReleaseDate,  Rating,  AgeRating,  Room ,  MovieLanguage ,
                regularSeatPrice ,  vipSeatPrice ,  ImagePath ,  status ,  ShowTime);
        
        Movies.add(movie);

    }
    public void addshowTime(Movie movie, Theater salle, LocalDate dateTime){
        Broadcast Diffustion = new Broadcast( movie, salle, dateTime);
        showTimes.add(Diffustion);
    }

    public Boolean CheckifMovieExist(String Title){
        for (Movie movie : Movies) {
            if (movie.Title.equals(Title)) {
               
                return true;
            }
        }
        return false;
    }
}
