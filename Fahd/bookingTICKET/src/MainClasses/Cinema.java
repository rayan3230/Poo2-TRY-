package MainClasses;

import ManagementClasses.*;
import Personnel.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {

    public ArrayList<Movie> movies;
    public ArrayList<Admin> admins;
    public ArrayList<Theater> theaters;
    public ArrayList<Ticket> tickets;
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
        this.admins = new ArrayList<Admin>();
        this.theaters = new ArrayList<Theater>();
        this.tickets = new ArrayList<Ticket>();

        this.filter = new Filters();
    }

    public void AddMovie(Movie movie) {
        movies.add(movie);
    }

    public void AddAdmin(Admin admin) {
        admins.add(admin);
    }

    public void AddTheater(Theater theater) {
        theaters.add(theater);
    }

    public void RemoveMovie(Movie movie) {
        movies.remove(movie);
    }

    public void RemoveAdmin(Admin admin) {
        admins.remove(admin);
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

    public void DisplayMovieDates() {
        System.out.println("Available Movie Dates: ");
        for (Movie movie : movies) {
            System.out.print("Title: " + movie.Title + ", Date: ");
            for (Ticket ticket : tickets) {
                if (ticket.movie == movie) {
                    System.out.print(ticket.Date + ", ");
                }
            }
            System.out.println(" ");
        }
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

    public void DisplayMoviesByTicketType(String ticketType) {
        for (Ticket ticket : tickets) {
            if (ticket.Type.equalsIgnoreCase(ticketType)) {
                System.out.println("---------------------------------------------");
                System.out.println("Title: " + ticket.movie.Title);
                System.out.println("Date: " + ticket.Date);
                System.out.println("Type: " + ticket.Type);
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
                DisplayMovieDates();
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
                    DisplayMoviesByTicketType(filter.TicketType);
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

}
