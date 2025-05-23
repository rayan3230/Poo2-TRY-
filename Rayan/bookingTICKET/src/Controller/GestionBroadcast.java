package Controller;

import Moodle.Broadcast;
import Moodle.Hall;
import Moodle.Movie;
import Moodle.Movie.MovieAgeRating;
import Moodle.Movie.genre;
import Moodle.Movie.statusFilm;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GestionBroadcast {
    public ArrayList<Broadcast> broadcasts = new ArrayList<>();

    public GestionBroadcast() {
        Movie movie = new Movie("The Dark Knight", "Batman", 120, genre.ACTION, "PG-13", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\film1.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30) ,LocalTime.of(12, 30),MovieAgeRating.PG13);
        Movie movie2 = new Movie( "Spiderman", "Batman", 120, genre.ACTION, "PG-13", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30) ,LocalTime.of(12, 30),MovieAgeRating.PG13);
        Movie movie3 = new Movie( "Avatar", "Batman", 120, genre.ACTION, "PG-13", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
        Movie movie4 = new Movie("it", "Batman", 120, genre.ACTION, "PG-13", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30) ,LocalTime.of(12,30),MovieAgeRating.PG13);
        Movie movie5 = new Movie("Game of throans", "Batman", 120, genre.ACTION, "PG-13", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30) ,LocalTime.of(12,30),MovieAgeRating.PG13);
        Movie movie6 = new Movie("Iron man 1", "Batman", 120, genre.ACTION, "PG-13", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
        Movie movie7 = new Movie("Iron man 2", "Batman", 120, genre.ACTION, "PG-13", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
       Movie movie8 = new Movie("Iron man 3", "Batman", 120, genre.ACTION, "PG-13", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
        Movie movie9 = new Movie("Avengers", "Batman", 120, genre.ACTION, "PG-13", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
        Movie movie10 = new Movie("A way out", "Batman", 120, genre.ACTION, "PG-13", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
         Movie movie11 = new Movie("Cupidon", "Batman", 120, genre.ACTION, "PG-13", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
         Movie movie12 = new Movie("Papilion", "Batman", 120, genre.ACTION, "PG-13", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
         Movie movie13 = new Movie("Jupiter", "Batman", 120, genre.ACTION, "PG-13", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
         Movie movie14 = new Movie("Lunar", "Batman", 120, genre.ACTION, "PG-13", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
         Movie movie15 = new Movie("The maze runner", "Batman", 120, genre.ACTION, "PG-13", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
         Movie movie16 = new Movie("Ant man", "Batman", 120, genre.ACTION, "PG-13", 10.0, 15.0, "C:\\Users\\HP\\Documents\\GitHub Mine\\POO2\\\\Poo2-TRY-\\Rayan\\bookingTICKET\\img\\Fandf.jpg" , statusFilm.AVAILABLE,LocalDate.of(2030,12,30)  ,LocalTime.of(12,30),MovieAgeRating.PG13);
        // Create halls and add them to broadcasts
        Hall hall1 = new Hall( "Aljawhra", 100, 50);
        Hall hall2 = new Hall( "Garden city", 100, 50);
        Hall hall3 = new Hall( "cosmos", 100, 50);
        
        broadcasts.add(new Broadcast(movie, hall1, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie2, hall2, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie3, hall3, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie, hall1, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie2, hall2, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie3, hall3, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie4, hall1, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie5, hall2, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie6, hall3, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie, hall1, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie2, hall2, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie3, hall3, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie7, hall1, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie8, hall2, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie9, hall3, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie10, hall1, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie11, hall2, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie12, hall3, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie13, hall1, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie14, hall2, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie15, hall3, LocalDate.of(2021, 12, 1)));
        broadcasts.add(new Broadcast(movie16, hall1, LocalDate.of(2021, 12, 1)));

    }

    public void addBroadcast(Movie movie, Hall theater, LocalDate date) {
        Broadcast broadcast = new Broadcast(movie, theater, date);
    }
    public void displayallbroadcasts() {
        for (Broadcast broadcast : broadcasts) {
            System.out.println("Movie: " + broadcast.movie.Title);
            System.out.println("Theater: " + broadcast.Room.NameHall);
            System.out.println("Date: " + broadcast.Date);
            System.out.println();
        }
    }

}
