package Mainclasses;


import Manageclasses.*;
import Manageclasses.Movie.Genre;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        Theater Room1 = new Theater(1, 100, 1, true);
        Theater Room2 = new Theater(2, 150, 2, true);
        Theater Room3 = new Theater(3, 200, 3, true);
        Theater Room4 = new Theater(4, 250, 4, true);
        Theater Room5 = new Theater(5, 300, 5, true);

        cinema.AddTheater(Room1);
        cinema.AddTheater(Room2);
        cinema.AddTheater(Room3);
        cinema.AddTheater(Room4);
        cinema.AddTheater(Room5);

        Movie Movie1 = new Movie("Interstellar", Genre.SCIENCE_FICTION, 1.75f,
"A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
"Christopher Nolan", "Matthew McConaughey, Anne Hathaway, Jessica Chastain",
"2014-11-07", 8.6f, Movie.AgeRating.PG6, Room1);

Movie Movie2 = new Movie("Batman: The Dark Knight", Genre.ACTION, 1.5f,
"When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
"Christopher Nolan", "Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page",
"2010-07-16", 9.5f, Movie.AgeRating.PG88, Room3);

Movie Movie3 = new Movie("The Dark Knight", Genre.ACTION, 2.5f,
"When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
"Christopher Nolan", "Christian Bale, Heath Ledger, Aaron Eckhart",
"2008-07-18", 9.0f, Movie.AgeRating.PG8, Room2);

Movie Movie4 = new Movie("Inception", Genre.SCIENCE_FICTION, 2.48f,
"A thief who enters the dreams of others to steal secrets from their subconscious is offered a chance to regain his old life as payment for a task considered to be impossible: 'inception'.",
"Christopher Nolan", "Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page",
"2010-07-16", 8.8f, Movie.AgeRating.PG12, Room4);

Movie Movie5 = new Movie("Pulp Fiction", Genre.CRIME, 2.54f,
"The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
"Quentin Tarantino", "John Travolta, Uma Thurman, Samuel L. Jackson",
"1994-10-14", 8.9f, Movie.AgeRating.PG8, Room5);

        cinema.AddMovie(Movie1);
        cinema.AddMovie(Movie2);
        cinema.AddMovie(Movie3);
        cinema.AddMovie(Movie4);
        cinema.AddMovie(Movie5);

        cinema.DisplayMovie();
        System.out.println("Main function executed.");
    }
}
        
