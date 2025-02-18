package Mainclasses;

import Manageclasses.Theater;
import Manageclasses.Movie;
import Manageclasses.Movie.Genre;
import Presocalsses.Admin;
import Manageclasses.Tkt;
import Presocalsses.Client;
import Manageclasses.Fltrs;


import java.util.ArrayList;

public class Cinema {

    public ArrayList<Movie> movies;
    public ArrayList<Theater> theaters;
    public ArrayList<Tkt> tkt;
    public ArrayList<Admin> admins;
    public ArrayList<Client> clients;
    public Fltrs filter;

    public String[] Genres = { "Action", "Comedy", "Drama", "Horror", "Science_Fiction", "Thriller",
            "Adventure", "Fantasy", "Mystery", "Romance", "Crime", "Animation", "Music", "Documentary",
            "Family", "Sport", "News", "Travel", "Game", "History" };

    public String[] AgeRestrictions = { "G", "PG6", "PG8", "PG13", "PG16", "PG18" };
    public String[] TicketType = { "VIP", "Normal" };

    public int filterCount = 0;
    public int[] filterList;
    public String[] Filters = { "Genre", "Age Restriction", "Duration", "Rating", "Date", "Ticket Type", "Release Date",
            "Seats" };

    public Cinema() {
        this.movies = new ArrayList<Movie>();
        this.tkt = new ArrayList<>();
        this.tkt = new ArrayList<Tkt>();
        this.admins = new ArrayList<>();
        this.clients = new ArrayList<Client>();
        this.filter = new Fltrs();

        // Initialize theaters
        Theater Room1 = new Theater(200, 40, 1, true);
        Theater Room2 = new Theater(300, 60, 2, true);
        Theater Room3 = new Theater(400, 80, 3, true);
        Theater Room4 = new Theater(200, 40, 4, true);
        Theater Room5 = new Theater(300, 60, 5, true);
        Theater Room6 = new Theater(200, 40, 6, true);
        Theater Room7 = new Theater(200, 40, 7, true);

        AddTheater(Room1);
        AddTheater(Room2);
        AddTheater(Room3);
        AddTheater(Room4);
        AddTheater(Room5);
        AddTheater(Room6);
        AddTheater(Room7);

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
        AddMovie(Movie1);
        AddMovie(Movie2);
        AddMovie(Movie3);
        AddMovie(Movie4);
        AddMovie(Movie5);
        
    }

    public void AddMovie(Movie movie) {
        movies.add(movie);
    }

    public void AddTheater(Theater theater) {
        theaters.add(theater);
    }

    public void AddTicket(Tkt Ticket) {
        tkt.add(Ticket);
    }

    public void RemoveTicket(Tkt ticket) {
        tkt.remove(ticket);
    }

    public void RemoveMovie(Movie movie) {
        movies.remove(movie);
    }

    public void RemoveTheater(Theater theater) {
        theaters.remove(theater);
    }
public void DisplayMovie() {
    for (Movie movie : movies) {
        System.out.println("---------------------------------------------");
        System.out.println("Title: " + movie.getTitle());
        System.out.println("Genre: " + movie.getGenre());
        System.out.println("Duration: " + movie.getDuration() + " minutes");
        System.out.println("Release Date: " + movie.getReleaseDate());
        System.out.println("Rating: " + movie.getRating());
        System.out.println("Age Rating: " + movie.getAgeRating());
        System.out.println("Description: " + movie.getDescription());
        System.out.println("Director: " + movie.getDirector());
        System.out.println("Cast: " + movie.getCast());
        System.out.println("---------------------------------------------");
    }
}
        public void DisplayAdmin() {
        for (Admin admin : admins) {
            System.out.println("---------------------------------------------");
            System.out.println("Name: " + admin.FirstName + " " + admin.LastName);
            System.out.println("Age: " + admin.Age);
            System.out.println("Email: " + admin.Email);
            System.out.println("Phone Number: " + admin.PhoneNumber);
            System.out.println("---------------------------------------------");
        }
    }

    public void DisplayTheater() {
        for (Theater theater : theaters) {
            System.out.println("---------------------------------------------");
            System.out.println("Theater Number: " + theater.TheaterId);
            System.out.println("Capacity: " + theater.NormalCapacity);
            System.out.println("VIP places : " + theater.VipCapacity);
            System.out.println("availability : " + theater.Available);
            System.out.println("---------------------------------------------");
        }
    }

    public void DisplayGenrer() {
        System.out.println("Available Genres: ");
        System.out.println("1. Action");
        System.out.println("2. Comedy");
        System.out.println("3. Drama");
        System.out.println("4. Horror");
        System.out.println("5. Science Fiction");
        System.out.println("6. Thriller");
        System.out.println("7. Adventure");
        System.out.println("8. Fantasy");
        System.out.println("9. Mystery");
        System.out.println("10. Romance");
        System.out.println("11. Crime");
        System.out.println("12. Animation");
        System.out.println("13. Music");
        System.out.println("14. Documentary");
        System.out.println("15. Family");
        System.out.println("16. Sport");
        System.out.println("17. News");
        System.out.println("18. Travel");
        System.out.println("19. Game");
        System.out.println("20. History");
    }

    public void DisplayAgeRestriction() {
        System.out.println("Available Age Restrictions: ");
        System.out.println("1. G");
        System.out.println("2. PG6");
        System.out.println("3. PG8");
        System.out.println("4. PG13");
        System.out.println("5. PG16");
        System.out.println("6. PG18");
    }

    public void DisplayTicketType() {
        System.out.println("Available Ticket Types: ");
        System.out.println("1. VIP");
        System.out.println("2. Normal");
    }

    public void DisplayMovieDates() {
        System.out.println("Available Movie Dates: ");
        for (Movie movie : movies) {
            System.out.print("Title: " + movie.getTitle() + ", Date: ");
            for (Tkt ticket : tkt) {
                if (ticket.movie == movie) {
                    System.out.print(ticket.getDate() + ", ");
                }
            }
            System.out.println(" ");
        }
    }

    public void DisplayMoviesByGenre(String genre) {
        for (Movie movie : movies) {
            if (movie.getGenre().toString().equalsIgnoreCase(genre)) {
                System.out.println("---------------------------------------------");
                System.out.println("Title: " + movie.getTitle());
                System.out.println("Genre: " + movie.getGenre());
                System.out.println("Duration: " + movie.getDuration() + " minutes");
                System.out.println("Release Date: " + movie.getReleaseDate());
                System.out.println("Rating: " + movie.getRating());
                System.out.println("Age Rating: " + movie.getAgeRating());
                System.out.println("Description: " + movie.getDescription());
                System.out.println("Director: " + movie.getDirector());
                System.out.println("Cast: " + movie.getCast());
                System.out.println("---------------------------------------------");
            }
        }
    }

    public void DisplayMoviesByAge(String age) {
        for (Movie movie : movies) {
            if (movie.getAgeRating().toString().equalsIgnoreCase(age)) {
                System.out.println("---------------------------------------------");
                System.out.println("Title: " + movie.getTitle());
                System.out.println("Genre: " + movie.getGenre());
                System.out.println("Duration: " + movie.getDuration() + " minutes");
                System.out.println("Release Date: " + movie.getReleaseDate());
                System.out.println("Rating: " + movie.getRating());
                System.out.println("Age Rating: " + movie.getAgeRating());
                System.out.println("Description: " + movie.getDescription());
                System.out.println("Director: " + movie.getDirector());
                System.out.println("Cast: " + movie.getCast());
                System.out.println("---------------------------------------------");
            }
        }
    }
    
    
    public void DisplayMoviesByDuration(String duration) {
        for (Movie movie : movies) {
            if (movie.getDuration() <= Integer.parseInt(duration)) {
                System.out.println("---------------------------------------------");
                System.out.println("Title: " + movie.getTitle());
                System.out.println("Genre: " + movie.getGenre());
                System.out.println("Duration: " + movie.getDuration() + " minutes");
                System.out.println("Release Date: " + movie.getReleaseDate());
                System.out.println("Rating: " + movie.getRating());
                System.out.println("Age Rating: " + movie.getAgeRating());
                System.out.println("Description: " + movie.getDescription());
                System.out.println("Director: " + movie.getDirector());
                System.out.println("Cast: " + movie.getCast());
                System.out.println("---------------------------------------------");
            }
        }
    
    }}