package controller;

import moodle.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {

    public ArrayList<Movie> movies;
    public ArrayList<Theater> theaters;
    public ArrayList<Ticket> tickets;
    public ArrayList<Broadcast> broadcasts;

    public ArrayList<Admin> admins;
    public ArrayList<Client> clients;

    public String[] Genres = { "Action", "Comedy", "Drama", "Horoor", "Science_Fiction", "Thriller",
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
        this.theaters = new ArrayList<Theater>();
        this.tickets = new ArrayList<Ticket>();
        this.admins = new ArrayList<Admin>();
        this.clients = new ArrayList<Client>();
        this.broadcasts = new ArrayList<Broadcast>();

        Client client1 = new Client("rayan", "mozali", "rayanmozali@gmail.com", 
                "0000", "rayan", "momo");

        addClient(client1);

        Admin admin1 = new Admin("fahd", "djedi", "fahd", "yuji", "manager");

        addAdmin(admin1);


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

        /*
        Movie Movie1 = new Movie("Interstellar", "Science_Fiction", 1.75f,
                "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                "Christopher Nolan", "Matthew McConaughey, Anne Hathaway, Jessica Chastain",
                "2014-11-07",
                8.6f, "PG13", Room1);

        Movie Movie2 = new Movie("Batman : the dark knight", "action", 1.5f,
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
                "Christopher Nolan", "Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page",
                "2010-07-16",
                9.5f, "PG18", Room3);

        Movie Movie3 = new Movie("The Dark Knight", "Action", 2.5f,
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
                "Christopher Nolan", "Christian Bale, Heath Ledger, Aaron Eckhart",
                "2008-07-18",
                9.0f, "PG13", Room2);

        Movie Movie4 = new Movie("Inception", "Science_Fiction", 2.48f,
                "A thief who enters the dreams of others to steal secrets from their subconscious is offered a chance to regain his old life as payment for a task considered to be impossible: 'inception'.",
                "Christopher Nolan", "Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page",
                "2010-07-16",
                8.8f, "PG13", Room4);

        Movie Movie5 = new Movie("Pulp Fiction", "Crime", 2.54f,
                "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
                "Quentin Tarantino", "John Travolta, Uma Thurman, Samuel L. Jackson",
                "1994-10-14",
                8.9f, "PG18", Room5);

        Movie Movie6 = new Movie("The Shawshank Redemption", "Drama", 2.37f,
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                "Frank Darabont", "Tim Robbins, Morgan Freeman, Bob Gunton",
                "1994-09-23",
                9.3f, "PG16", Room6);

        Movie Movie7 = new Movie("The Matrix", "Science_Fiction", 2.30f,
                "A computer programmer discovers that reality as he knows it is a simulation created by machines to subjugate humanity.",
                "The Wachowskis", "Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss",
                "1999-03-31",
                8.7f, "PG13", Room7);

        Movie Movie8 = new Movie("Forrest Gump", "Drama", 2.22f,
                "The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75.",
                "Robert Zemeckis", "Tom Hanks, Robin Wright, Gary Sinise",
                "1994-07-06",
                8.8f, "PG13", Room1);

        Movie Movie9 = new Movie("The Godfather", "Crime", 2.55f,
                "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
                "Francis Ford Coppola", "Marlon Brando, Al Pacino, James Caan",
                "1972-03-24",
                9.2f, "PG18", Room2);*/



        // Create movies
        Movie Movie1 = new Movie("Avengers: Endgame", "Action", 3.02f,
                "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.",
                "Anthony Russo, Joe Russo", "Robert Downey Jr., Chris Evans, Mark Ruffalo",
                "2019-04-26",
                8.4f, "PG13", Room1);

        Movie Movie2 = new Movie("Joker", "Crime", 2.02f,
                "In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.",
                "Todd Phillips", "Joaquin Phoenix, Robert De Niro, Zazie Beetz",
                "2019-10-04",
                8.5f, "R", Room2);

        Movie Movie3 = new Movie("Parasite", "Thriller", 2.12f,
                "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.",
                "Bong Joon Ho", "Kang-ho Song, Sun-kyun Lee, Yeo-jeong Jo",
                "2019-05-30",
                8.6f, "R", Room3);

        Movie Movie4 = new Movie("Blair Witch", "Horror", 1.29f,
                "After discovering a video showing what he believes to be his vanished sister Heather, James and a group of friends head to the forest believed to be inhabited by the Blair Witch.",
                "Adam Wingard", "James Allen McCune, Callie Hernandez, Corbin Reid",
                "2016-09-16",
                5.0f, "PG13", Room4);

        Movie Movie5 = new Movie("Batman: Arkham Knight", "Action", 1.75f,
                "Batman faces the ultimate threat against the city he is sworn to protect. The Scarecrow returns to unite an impressive roster of super villains, including Penguin, Two-Face, and Harley Quinn, to destroy The Dark Knight forever.",
                "Sefton Hill", "Kevin Conroy, John Noble, Jonathan Banks",
                "2015-06-23",
                9.0f, "PG13", Room5);

        Movie Movie6 = new Movie("The Gorge", "Thriller", 2.10f,
                "A thrilling story set in a remote gorge where a group of friends must survive against all odds.",
                "Scott Derrickson", "Ethan Hawke, Jeremy Renner, Elizabeth Olsen",
                "2023-10-13",
                7.5f, "PG16", Room6);

        Movie Movie7 = new Movie("The Batman", "Action", 2.55f,
                "When a sadistic serial killer begins murdering key political figures in Gotham, Batman is forced to investigate the city's hidden corruption and question his family's involvement.",
                "Matt Reeves", "Robert Pattinson, Zoë Kravitz, Jeffrey Wright",
                "2022-03-04",
                8.2f, "PG13", Room7);

        Movie Movie8 = new Movie("Deadpool 2", "Action", 2.00f,
                "Foul-mouthed mutant mercenary Wade Wilson (a.k.a. Deadpool), brings together a team of fellow mutant rogues to protect a young boy with supernatural abilities from the brutal, time-traveling cyborg Cable.",
                "David Leitch", "Ryan Reynolds, Josh Brolin, Morena Baccarin",
                "2018-05-18",
                7.7f, "PG18", Room1);

        Movie Movie9 = new Movie("Vice Versa 2", "Animation", 1.45f,
                "The sequel to the beloved animated film, following the adventures of Riley and her emotions as they navigate new challenges.",
                "Pete Docter", "Amy Poehler, Bill Hader, Lewis Black",
                "2023-11-22",
                8.0f, "PG", Room2);

        AddMovie(Movie1);
        AddMovie(Movie2);
        AddMovie(Movie3);
        AddMovie(Movie4);
        AddMovie(Movie5);
        AddMovie(Movie6);
        AddMovie(Movie7);
        AddMovie(Movie8);
        AddMovie(Movie9);

        Broadcast Broadcast1 = new Broadcast(Movie1, Room1, "2025-03-01");
        Broadcast Broadcast2 = new Broadcast(Movie2, Room2, "2025-03-10");
        Broadcast Broadcast3 = new Broadcast(Movie3, Room3, "2025-03-20");
        Broadcast Broadcast4 = new Broadcast(Movie4, Room4, "2025-05-05");
        Broadcast Broadcast5 = new Broadcast(Movie5, Room5, "2025-05-15");
        Broadcast Broadcast6 = new Broadcast(Movie6, Room6, "2025-05-25");
        Broadcast Broadcast7 = new Broadcast(Movie7, Room7, "2025-04-10");
        Broadcast Broadcast8 = new Broadcast(Movie8, Room1, "2025-05-30");
        Broadcast Broadcast9 = new Broadcast(Movie9, Room2, "2025-04-20");

        addBroadcast(Broadcast1);
        addBroadcast(Broadcast2);
        addBroadcast(Broadcast3);
        addBroadcast(Broadcast4);
        addBroadcast(Broadcast5);
        addBroadcast(Broadcast6);
        addBroadcast(Broadcast7);
        addBroadcast(Broadcast8);
        addBroadcast(Broadcast9);



    }

    public boolean isAdmin(String email, String password ){
        //Check if the admin credentials match with the stored admin credentials
        for(Admin admin : admins){
            if(admin.username.equals(email) && admin.password.equals(password)){
                return true;
            }
        }
        
        return false;
    }

    public boolean isClient(String email, String password ){
        //Check if the client credentials match with the stored client credentials
        for(Client client : clients){
            if((client.username.equals(email) || client.Email.equals(email))
                && (client.password.equals(password))){
                return true;
            }
        }
        
        //If client credentials don't match, add the client to the clients list
        return false;
    }

    public Client getClient(String username, String password){
        //Check if the client credentials match with the stored client credentials
        for(Client client : clients){
            if((client.username.equals(username) || client.Email.equals(username) || client.PhoneNumber.equals(username))
                && (client.password.equals(password))){
                return client;
            }
        }
        
        //If client credentials don't match, return null
        return null;
    }

    public Admin getAdmin(String username, String password){
        //Check if the client credentials match with the stored client credentials
        for(Admin admin : admins){
            if((admin.username.equals(username) || admin.Email.equals(username) || admin.PhoneNumber.equals(username))
                && (admin.password.equals(password))){
                return admin;
            }
        }
        
        //If client credentials don't match, return null
        return null;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }


    public void AddMovie(Movie movie) {
        movies.add(movie);
    }


    public void AddTheater(Theater theater) {
        theaters.add(theater);
    }

    public void RemoveMovie(Movie movie) {
        movies.remove(movie);
    }

    public void RemoveTheater(Theater theater) {
        theaters.remove(theater);
    }

    public void addBroadcast(Broadcast broadcast) {
        broadcasts.add(broadcast);
    }

    public void removeBroadcast(Broadcast broadcast) {
        broadcasts.remove(broadcast);
    }

    public void DisplayMovie() {
        for (Movie movie : movies) {
            System.out.println("---------------------------------------------");
            System.out.println("Title: " + movie.Title);
            System.out.println("Genre: " + movie.Genre);
            System.out.println("Duration: " + movie.Duration + " minutes");
            System.out.println("Release Date: " + movie.ReleaseDate);
            System.out.println("Rating: " + movie.Rating);
            System.out.println("Age Rating: " + movie.AgeRating);
            System.out.println("Description: " + movie.Description);
            System.out.println("Director: " + movie.Director);
            System.out.println("Cast: " + movie.Cast);
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

    public void DisplaySeats(int[] seats) {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                System.out.print("Seat " + (i + 1) + " is booked. ");
            } else {
                System.out.print("Seat " + (i + 1) + " is available. ");
            }
        }
        System.out.println();
    }

    public void DisplayAvailableSeatsInRoom(Theater Room) {
        System.out.println("Normal places reamining  :  " + (Room.NormalCapacity - Room.NormalReservedPlaces)
                + " VIP places remaining  :  " + (Room.VipCapacity - Room.VipReservedPlaces));
    }


    public void DisplayBroadcast(){
        System.out.println("Broadcasting movies : ");
        for(Broadcast broadcast : broadcasts){
            System.out.println("---------------------------------------------");
            System.out.println("Movie Title: " + broadcast.movie.Title);
            System.out.println("Theater Number: " + broadcast.Room.TheaterId);
            System.out.println("Broadcast Date: " + broadcast.Date);
            System.out.println("---------------------------------------------");
        }
    }
}
