package MainClasses;

import ManagementClasses.*;
import Personnel.*;
import java.util.ArrayList;

public class Cinema {

    public ArrayList<Movie> movies;
    public ArrayList<Theater> theaters;
    public ArrayList<Ticket> tickets;
    public ArrayList<Broadcast> broadcasts;

    public ArrayList<Admin> admins;
    public ArrayList<Client> clients;
    

    public enum Genre {
        Action, Comedy, Drama, Horror, Science_Fiction, Thriller, Adventure, Fantasy, Mystery, Romance, Crime,
        Animation, Music, Documentary, Family, Sport, News, Travel, Game, History

    }

    public enum AgeRating {
        G, PG6, PG8, PG13, PG16, PG18
    }

    public enum TicketType {
        VIP, Normal, NULL
    }

    

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

        // Create movies and broadcast
        Movie Movie1 = new Movie("Avengers: Endgame", Cinema.Genre.Action, 3.02f,
                "After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.",
                "Anthony Russo, Joe Russo", "Robert Downey Jr., Chris Evans, Mark Ruffalo",
                "2019-04-26",
                8.4f, Cinema.AgeRating.PG13);

        Movie Movie2 = new Movie("Joker", Cinema.Genre.Crime, 2.02f,
                "In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.",
                "Todd Phillips", "Joaquin Phoenix, Robert De Niro, Zazie Beetz",
                "2019-10-04",
                8.5f, Cinema.AgeRating.PG18);

        Movie Movie3 = new Movie("Parasite", Cinema.Genre.Thriller, 2.12f,
                "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.",
                "Bong Joon Ho", "Kang-ho Song, Sun-kyun Lee, Yeo-jeong Jo",
                "2019-05-30",
                8.6f, Cinema.AgeRating.PG16);

        Movie Movie4 = new Movie("Blair Witch", Cinema.Genre.Horror, 1.29f,
                "After discovering a video showing what he believes to be his vanished sister Heather, James and a group of friends head to the forest believed to be inhabited by the Blair Witch.",
                "Adam Wingard", "James Allen McCune, Callie Hernandez, Corbin Reid",
                "2016-09-16",
                5.0f, Cinema.AgeRating.PG18);

        Movie Movie5 = new Movie("Batman: Arkham Knight", Cinema.Genre.Action, 1.75f,
                "Batman faces the ultimate threat against the city he is sworn to protect. The Scarecrow returns to unite an impressive roster of super villains, including Penguin, Two-Face, and Harley Quinn, to destroy The Dark Knight forever.",
                "Sefton Hill", "Kevin Conroy, John Noble, Jonathan Banks",
                "2015-06-23",
                9.0f, Cinema.AgeRating.PG16);

        Movie Movie6 = new Movie("The Gorge", Cinema.Genre.Thriller, 2.10f,
                "A thrilling story set in a remote gorge where a group of friends must survive against all odds.",
                "Scott Derrickson", "Ethan Hawke, Jeremy Renner, Elizabeth Olsen",
                "2023-10-13",
                7.5f, Cinema.AgeRating.PG16);

        Movie Movie7 = new Movie("The Batman", Cinema.Genre.Action, 2.55f,
                "When a sadistic serial killer begins murdering key political figures in Gotham, Batman is forced to investigate the city's hidden corruption and question his family's involvement.",
                "Matt Reeves", "Robert Pattinson, Zoë Kravitz, Jeffrey Wright",
                "2022-03-04",
                8.2f, Cinema.AgeRating.PG16);

        Movie Movie8 = new Movie("Deadpool 2", Cinema.Genre.Action, 2.00f,
                "Foul-mouthed mutant mercenary Wade Wilson (a.k.a. Deadpool), brings together a team of fellow mutant rogues to protect a young boy with supernatural abilities from the brutal, time-traveling cyborg Cable.",
                "David Leitch", "Ryan Reynolds, Josh Brolin, Morena Baccarin",
                "2018-05-18",
                7.7f, Cinema.AgeRating.PG18);

        Movie Movie9 = new Movie("Vice Versa 2", Cinema.Genre.Animation, 1.45f,
                "The sequel to the beloved animated film, following the adventures of Riley and her emotions as they navigate new challenges.",
                "Pete Docter", "Amy Poehler, Bill Hader, Lewis Black",
                "2023-11-22",
                8.0f, Cinema.AgeRating.G);

        Movie Movie10 = new Movie("The Hangover", Cinema.Genre.Comedy, 1.40f,
                "Three buddies wake up from a bachelor party in Las Vegas, with no memory of the previous night and the bachelor missing.",
                "Todd Phillips", "Bradley Cooper, Ed Helms, Zach Galifianakis",
                "2009-06-05",
                7.7f, Cinema.AgeRating.PG18);
        
        Movie Movie11 = new Movie("The Shawshank Redemption", Cinema.Genre.Drama, 2.22f,
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                "Frank Darabont", "Tim Robbins, Morgan Freeman, Bob Gunton",
                "1994-09-23",
                9.3f, Cinema.AgeRating.PG16);
        
        Movie Movie12 = new Movie("Interstellar", Cinema.Genre.Science_Fiction, 2.49f,
                "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                "Christopher Nolan", "Matthew McConaughey, Anne Hathaway, Jessica Chastain",
                "2014-11-07",
                8.6f, Cinema.AgeRating.PG13);
        
        Movie Movie13 = new Movie("The Lord of the Rings: The Fellowship of the Ring", Cinema.Genre.Adventure, 2.58f,
                "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.",
                "Peter Jackson", "Elijah Wood, Ian McKellen, Orlando Bloom",
                "2001-12-19",
                8.8f, Cinema.AgeRating.PG13);
        
        Movie Movie14 = new Movie("Harry Potter and the Sorcerer's Stone", Cinema.Genre.Fantasy, 2.32f,
                "An orphaned boy enrolls in a school of wizardry, where he learns the truth about himself, his family and the terrible evil that haunts the magical world.",
                "Chris Columbus", "Daniel Radcliffe, Rupert Grint, Emma Watson",
                "2001-11-16",
                7.6f, Cinema.AgeRating.PG13);
        
        Movie Movie15 = new Movie("Knives Out", Cinema.Genre.Mystery, 2.10f,
                "A detective investigates the death of a patriarch of an eccentric, combative family.",
                "Rian Johnson", "Daniel Craig, Chris Evans, Ana de Armas",
                "2019-11-27",
                7.9f, Cinema.AgeRating.PG13);
        
        Movie Movie16 = new Movie("Titanic", Cinema.Genre.Romance, 3.14f,
                "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.",
                "James Cameron", "Leonardo DiCaprio, Kate Winslet, Billy Zane",
                "1997-12-19",
                7.8f, Cinema.AgeRating.PG13);
        
        Movie Movie17 = new Movie("Free Solo", Cinema.Genre.Documentary, 1.40f,
                "Follow Alex Honnold as he becomes the first person to ever free solo climb Yosemite's 3,000ft high El Capitan wall.",
                "Elizabeth Chai Vasarhelyi, Jimmy Chin", "Alex Honnold, Tommy Caldwell, Jimmy Chin",
                "2018-09-28",
                8.2f, Cinema.AgeRating.PG13);
        
        Movie Movie18 = new Movie("The Incredibles", Cinema.Genre.Family, 1.55f,
                "A family of undercover superheroes, while trying to live the quiet suburban life, are forced into action to save the world.",
                "Brad Bird", "Craig T. Nelson, Samuel L. Jackson, Holly Hunter",
                "2004-11-05",
                8.0f, Cinema.AgeRating.PG13);
        
        Movie Movie19 = new Movie("Rocky", Cinema.Genre.Sport, 2.00f,
                "A small-time boxer gets a supremely rare chance to fight a heavyweight champion in a bout in which he strives to go the distance for his self-respect.",
                "John G. Avildsen", "Sylvester Stallone, Talia Shire, Burt Young",
                "1976-12-03",
                8.1f, Cinema.AgeRating.PG16);
        
        Movie Movie20 = new Movie("The Social Network", Cinema.Genre.History, 2.00f,
                "The story of the founding of Facebook and the lawsuits that followed.",
                "David Fincher", "Jesse Eisenberg, Andrew Garfield, Justin Timberlake",
                "2010-10-01",
                7.7f, Cinema.AgeRating.PG13);

        Movie Movie21 = new Movie("Bohemian Rhapsody", Cinema.Genre.Music, 2.14f,
                "The story of the legendary British rock band Queen and lead singer Freddie Mercury, leading up to their famous performance at Live Aid.",
                "Bryan Singer", "Rami Malek, Lucy Boynton, Gwilym Lee",
                "2018-11-02",
                8.0f, Cinema.AgeRating.PG13);
        
        Movie Movie22 = new Movie("Anchorman: The Legend of Ron Burgundy", Cinema.Genre.News, 1.34f,
                "Ron Burgundy is San Diego's top-rated newsman in the male-dominated broadcasting of the 1970s, but that's all about to change for Ron and his cronies when an ambitious woman is hired as a new anchor.",
                "Adam McKay", "Will Ferrell, Christina Applegate, Steve Carell",
                "2004-07-09",
                7.2f, Cinema.AgeRating.PG13);
        
        Movie Movie23 = new Movie("The Secret Life of Walter Mitty", Cinema.Genre.Travel, 1.54f,
                "When his job along with that of his co-worker are threatened, Walter takes action in the real world embarking on a global journey that turns into an adventure more extraordinary than anything he could have ever imagined.",
                "Ben Stiller", "Ben Stiller, Kristen Wiig, Jon Daly",
                "2013-12-25",
                7.3f, Cinema.AgeRating.PG13);
        
        Movie Movie24 = new Movie("Jumanji: Welcome to the Jungle", Cinema.Genre.Game, 1.59f,
                "Four teenagers are sucked into a magical video game, and the only way they can escape is to work together to finish the game.",
                "Jake Kasdan", "Dwayne Johnson, Karen Gillan, Kevin Hart",
                "2017-12-20",
                6.9f, Cinema.AgeRating.PG13);
        
                
        AddMovie(Movie1);
        AddMovie(Movie2);
        AddMovie(Movie3);
        AddMovie(Movie4);
        AddMovie(Movie5);
        AddMovie(Movie6);
        AddMovie(Movie7);
        AddMovie(Movie8);
        AddMovie(Movie9);
        AddMovie(Movie10);
        AddMovie(Movie11);
        AddMovie(Movie12);
        AddMovie(Movie13);
        AddMovie(Movie14);
        AddMovie(Movie15);
        AddMovie(Movie16);
        AddMovie(Movie17);
        AddMovie(Movie18);
        AddMovie(Movie19);
        AddMovie(Movie20);
        AddMovie(Movie21);
        AddMovie(Movie22);
        AddMovie(Movie23);
        AddMovie(Movie24);


        Broadcast Broadcast1 = new Broadcast(Movie1, Room1, "2025-03-01");
        Broadcast Broadcast2 = new Broadcast(Movie2, Room2, "2025-03-10");
        Broadcast Broadcast3 = new Broadcast(Movie3, Room3, "2025-03-20");
        Broadcast Broadcast4 = new Broadcast(Movie4, Room4, "2025-05-05");
        Broadcast Broadcast5 = new Broadcast(Movie5, Room5, "2025-05-15");
        Broadcast Broadcast6 = new Broadcast(Movie6, Room6, "2025-05-25");
        Broadcast Broadcast7 = new Broadcast(Movie7, Room7, "2025-04-10");
        Broadcast Broadcast8 = new Broadcast(Movie8, Room1, "2025-05-30");
        Broadcast Broadcast9 = new Broadcast(Movie9, Room2, "2025-04-20");
        Broadcast Broadcast10 = new Broadcast(Movie10, Room3, "2025-06-01");
        Broadcast Broadcast11 = new Broadcast(Movie11, Room4, "2025-06-10");
        Broadcast Broadcast12 = new Broadcast(Movie12, Room5, "2025-06-20");
        Broadcast Broadcast13 = new Broadcast(Movie13, Room6, "2025-07-01");
        Broadcast Broadcast14 = new Broadcast(Movie14, Room7, "2025-07-10");
        Broadcast Broadcast15 = new Broadcast(Movie15, Room1, "2025-07-20");
        Broadcast Broadcast16 = new Broadcast(Movie16, Room2, "2025-08-01");
        Broadcast Broadcast17 = new Broadcast(Movie17, Room3, "2025-08-10");
        Broadcast Broadcast18 = new Broadcast(Movie18, Room4, "2025-08-20");
        Broadcast Broadcast19 = new Broadcast(Movie19, Room5, "2025-09-01");
        Broadcast Broadcast20 = new Broadcast(Movie20, Room6, "2025-09-10");
        Broadcast Broadcast21 = new Broadcast(Movie21, Room7, "2025-09-20");
        Broadcast Broadcast22 = new Broadcast(Movie22, Room1, "2025-10-01");
        Broadcast Broadcast23 = new Broadcast(Movie23, Room2, "2025-10-10");
        Broadcast Broadcast24 = new Broadcast(Movie24, Room3, "2025-10-20");

        addBroadcast(Broadcast1);
        addBroadcast(Broadcast2);
        addBroadcast(Broadcast3);
        addBroadcast(Broadcast4);
        addBroadcast(Broadcast5);
        addBroadcast(Broadcast6);
        addBroadcast(Broadcast7);
        addBroadcast(Broadcast8);
        addBroadcast(Broadcast9);
        addBroadcast(Broadcast10);
        addBroadcast(Broadcast11);
        addBroadcast(Broadcast12);
        addBroadcast(Broadcast13);
        addBroadcast(Broadcast14);
        addBroadcast(Broadcast15);
        addBroadcast(Broadcast16);
        addBroadcast(Broadcast17);
        addBroadcast(Broadcast18);
        addBroadcast(Broadcast19);
        addBroadcast(Broadcast20);
        addBroadcast(Broadcast21);
        addBroadcast(Broadcast22);
        addBroadcast(Broadcast23);
        addBroadcast(Broadcast24);
        

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

    public boolean isAdmin(String email, String password ){
        //Check if the admin credentials match with the stored admin credentials
        for(Admin admin : admins){
            if(admin.username.equals(email) && admin.password.equals(password)){
                return true;
            }
        }
        
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

    public void addBroadcast(Broadcast broadcast) {
        broadcasts.add(broadcast);
    }

    public Movie GetBestRatedMovie() {
        Movie BestRated = movies.get(0);
        for (Movie movie : movies) {
            if (movie.Rating > BestRated.Rating) {
                BestRated = movie;
            }
        }
        return BestRated;
    }

}
