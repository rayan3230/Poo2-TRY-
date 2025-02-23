package MainClasses;

import ManagementClasses.*;
import Personnel.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {

    public ArrayList<Movie> movies;
    public ArrayList<Theater> theaters;
    public ArrayList<Ticket> tickets;

    public ArrayList<Admin> admins;
    public ArrayList<Client> clients;
    
    public Filters filter;

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

        this.filter = new Filters();

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
                9.2f, "PG18", Room2);

        AddMovie(Movie1);
        AddMovie(Movie2);
        AddMovie(Movie3);
        AddMovie(Movie4);
        AddMovie(Movie5);
        AddMovie(Movie6);
        AddMovie(Movie7);
        AddMovie(Movie8);
        AddMovie(Movie9);

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

    public void AddTicket(Ticket Ticket) {
        tickets.add(Ticket);
    }

    public void RemoveTicket(Ticket ticket) {
        tickets.remove(ticket);
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

    public void DisplayMoviesByGenre(String genre) {
        for (Movie movie : movies) {
            if (movie.Genre.equalsIgnoreCase(genre)) {
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
    }

    public void DisplayMoviesByAge(String age) {
        for (Movie movie : movies) {
            if (movie.AgeRating.equalsIgnoreCase(age)) {
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
    }

    public void DisplayMoviesByDuration(String duration) {
        for (Movie movie : movies) {
            if (movie.Duration <= Integer.parseInt(duration)) {
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
    }

    public void DisplayMoviesByRating(int rating) {
        for (Movie movie : movies) {
            if (movie.Rating >= rating) {
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
    }

    public void DisplayMoviesByDate(String date) {
        for (Movie movie : movies) {
            if (movie.ReleaseDate.equalsIgnoreCase(date)) {
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
    }

    public void DisplayMoviesByReleaseDate(String releaseDate) {
        for (Movie movie : movies) {
            if (movie.ReleaseDate.equalsIgnoreCase(releaseDate)) {
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
    }

    public void DisplayMoviesByDuration(Float Duration) {
        for (Movie movie : movies) {
            if (movie.Duration <= Duration) {
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

    public void SetFilter() {
        System.out.println("Select a filter you want to apply : ");
        System.out.println("1. Genre");
        System.out.println("2. Age Restriction");
        System.out.println("3. Duration");
        System.out.println("4. Rating");
        System.out.println("5. Date");
        System.out.println("6. Ticket Type");
        System.out.println("7. Release Date");
        System.out.println("8. Seats");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        int x;
        switch (choice) {
            case 1:
                filterList[filterCount] = choice;
                filterCount++;
                System.out.println("Enter the genre you want to filter by : ");
                DisplayGenrer();
                x = scanner.nextInt();
                filter.SetGenreFilter(Genres[x]);
                break;
            case 2:
                filterList[filterCount] = choice;
                filterCount++;
                System.out.println("Enter the age restriction you want to filter by : ");
                DisplayAgeRestriction();
                x = scanner.nextInt();
                filter.SetAgeRestrictionFilter(AgeRestrictions[x]);
                break;
            case 3:
                filterList[filterCount] = choice;
                filterCount++;
                System.out.println("Enter the duration (in hours) you want to filter by : ");
                int duration = scanner.nextInt();
                filter.SetDurationFilter(duration);
                break;
            case 4:
                filterList[filterCount] = choice;
                filterCount++;
                System.out.println("Enter the rating you want to filter by (out of 10): ");
                int rating = scanner.nextInt();
                filter.SetRatingFilter(rating);
                break;
            case 5:
                filterList[filterCount] = choice;
                filterCount++;
                System.out.println("Enter the date you want to filter by (this mounth) : ");
                String date = scanner.next();
                filter.SetDateFilter(date);
                break;
            case 6:
                filterList[filterCount] = choice;
                filterCount++;
                System.out.println("Enter the ticket type you want to filter by : ");
                DisplayTicketType();
                String ticketType = scanner.next();
                filter.SetTicketTypeFilter(ticketType);
                break;
            case 7:
                filterList[filterCount] = choice;
                filterCount++;
                System.out.println("Enter the release date you want to filter by : ");
                String releaseDate = scanner.next();
                filter.SetReleaseDateFilter(releaseDate);
                break;
            case 8:
                filterList[filterCount] = choice;
                filterCount++;
                System.out.println("Enter the seats you want to filter by : ");
                int[] seats = new int[2];
                seats[0] = scanner.nextInt();
                seats[1] = scanner.nextInt();
                filter.SetSeatsFilter(seats);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        scanner.close();
    }

    public void ApplyFilter() {
        for (int i = 0; i < filterCount; i++) {
            switch (filterList[i]) {
                case 1:
                    DisplayMoviesByGenre(filter.Genre);
                    break;
                case 2:
                    DisplayMoviesByAge(filter.AgeRestriction);
                    break;
                case 3:
                    DisplayMoviesByDuration(filter.Duration);
                    break;
                case 4:
                    DisplayMoviesByRating(filter.Rating);
                    break;
                case 5:
                    DisplayMoviesByDate(filter.Date);
                    break;
                case 6:
                
                    break;
                case 7:
                    DisplayMoviesByReleaseDate(filter.ReleaseDate);
                    break;
                case 8:
                    DisplaySeats(filter.Seats);
                    break;
            }
        }
    }

    public void DisplayAvailableSeatsInRoom(Theater Room) {
        System.out.println("Normal places reamining  :  " + (Room.NormalCapacity - Room.NormalReservedPlaces)
                + " VIP places remaining  :  " + (Room.VipCapacity - Room.VipReservedPlaces));
    }

}
