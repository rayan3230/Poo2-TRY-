package Controller;

import Moodle.*;
import Moodle.Movie.MovieAgeRating;
import Moodle.Movie.genre;
import Moodle.Movie.statusFilm;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class GestionMovie {
    public ArrayList<Movie> Movies = new ArrayList<>();
    public ArrayList<ShowTime> showTimes = new ArrayList<>();
    public int movieCount = 0;
    public int showTimeCount = 0;

    public GestionMovie() {
        Movie movie = new Movie("The Dark Knight", "Batman", 120, genre.COMEDY, "9,4", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\film1.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30) ,LocalTime.of(12, 30),MovieAgeRating.PG13);
        Movie movie2 = new Movie( "Spiderman", "Batman", 120, genre.COMEDY, "9,4", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30) ,LocalTime.of(12, 30),MovieAgeRating.PG13);
        Movie movie3 = new Movie( "Avatar", "Batman", 120, genre.DRAMA, "9,4", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
        Movie movie4 = new Movie("it", "Batman", 120, genre.ACTION, "9,4", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30) ,LocalTime.of(12,30),MovieAgeRating.PG13);
        Movie movie5 = new Movie("Game of throans", "Batman", 120, genre.ACTION, "9,4", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30) ,LocalTime.of(12,30),MovieAgeRating.PG13);
        Movie movie6 = new Movie("Iron man 1", "Batman", 120, genre.ACTION, "9,4", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
        Movie movie7 = new Movie("Iron man 2", "Batman", 120, genre.ACTION, "9,4", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
         Movie movie8 = new Movie("Iron man 3", "Batman", 120, genre.ACTION, "9,4", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
        Movie movie9 = new Movie("Avengers", "Batman", 120, genre.ACTION, "9,4", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
        Movie movie10 = new Movie("A way out", "Batman", 120, genre.ACTION, "9,4", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
         Movie movie11 = new Movie("Cupidon", "Batman", 120, genre.ACTION, "9,4", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
         Movie movie12 = new Movie("Papilion", "Batman", 120, genre.ACTION, "9,4", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
         Movie movie13 = new Movie("Jupiter", "Batman", 120, genre.ACTION, "9,4", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
         Movie movie14 = new Movie("Lunar", "Batman", 120, genre.ACTION, "9,4", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
         Movie movie15 = new Movie("The maze runner", "Batman", 120, genre.ACTION, "9,4", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
         Movie movie16 = new Movie("Ant man", "Batman", 120, genre.ACTION, "9,4", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
        Movies.add(movie);
        Movies.add(movie2);
        Movies.add(movie3);
        Movies.add(movie4);
        Movies.add(movie5);
        Movies.add(movie6);
        Movies.add(movie7);
        Movies.add(movie8);
        Movies.add(movie9);
        Movies.add(movie10);
        Movies.add(movie11);
        Movies.add(movie12);
        Movies.add(movie13);
        Movies.add(movie14);
        Movies.add(movie15);
        Movies.add(movie16);
    }

    public void addMovie(String Title,String Description, int duration, genre genre, String rating,
        double regularSeatPrice, double vipSeatPrice , String imagepath , statusFilm status ,LocalDate Releasedate ,LocalTime ShowTime ,MovieAgeRating AgeRating){
            movieCount++;
            Movie movie = new Movie(Title, Description, duration, genre,rating, regularSeatPrice, vipSeatPrice , imagepath, status , Releasedate,ShowTime,AgeRating);
        
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
            System.out.println("Genre: " + movie.MovieGenre);
            System.out.println("Rating: " + movie.rating);
            System.out.println("Regular Seat Price: " + movie.regularSeatPrice);
            System.out.println("VIP Seat Price: " + movie.vipSeatPrice);
            System.out.println("Image Path: " + movie.imagePath);
            System.out.println("Status: " + movie.statusfilm);
            System.out.println("Show Time: " + movie.showeTime);
            System.out.println();
        }
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
