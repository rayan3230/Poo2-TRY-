package Users_Classees;

import java.util.List;
import java.util.Scanner;

import Basic_Classes.Diffusion;
import Basic_Classes.Film;
import Basic_Classes.Salle;

public class Admin extends User {

    public String email;

    public Admin(String username, String password, String role, String email) {
        super(username, password, role);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addmovie(List<Film> movies, Film film){
        if (film != null) {
            movies.add(film);
            System.out.println("Movie added: " + film.getTitle());
        } else {
            System.out.println("Invalid movie.");
        }

    }

    public void deletemovie(List<Film> movies, String title){
        for (Film film : movies) {
            if (film.getTitle().equals(title)) {
                movies.remove(film);
                System.out.println("Movie deleted: " + film.getTitle());
                return;
            }
        }
        System.out.println("Movie not found.");


    }

    public void modifymovie(List<Film> movies, Film film){
        System.out.println("What do you want to modify in the movie? :" + film.getTitle());
        System.out.println("1. Title");
        System.out.println("2. Genre");
        System.out.println("3. Duration");
        System.out.println("4. Director");
        System.out.println("5. Synopsis");
        System.out.println("6. Age Restriction");
        int choice;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the new title: ");
                String newtitle = sc.next();
                film.setTitle(newtitle);
                System.out.println("Title modified. The new tile is: " + film.getTitle());
                break;
        
            case 2:
                System.out.println("Enter the new genre: ");
                String newgenre = sc.next();
                film.setGenre(newgenre);
                System.out.println("Genre modified. The new genre is: " + film.getGenre());
                break;

            case 3:
                System.out.println("Enter the new duration: ");
                int newduration = sc.nextInt();
                film.setDuration(newduration);
                System.out.println("Duration modified. The new duration is: " + film.getDuration());
                break;

            case 4:
                System.out.println("Enter the new director: ");
                String newdirector = sc.next();
                film.setDirector(newdirector);
                System.out.println("Director modified. The new director is: " + film.getDirector());
                break;
                
            case 5:
                System.out.println("Enter the new synopsis: ");
                String newsynopsis = sc.next();
                film.setsynopsis(newsynopsis);
                System.out.println("Synopsis modified. The new synopsis is: " + film.getsynopsis());
                break;

            case 6:
                System.out.println("Enter the new age restriction: ");
                String newage = sc.next();
                film.setAgeRestriction(newage);
                System.out.println("Age restriction modified. The new age restriction is: " + film.getAgeRestriction());
                break;
        }
        sc.close();

    }

    public void AddSalle(List<Salle> salles, Salle salle){
        if (salle != null) {
            salles.add(salle);
            System.out.println("Salle added: " + salle.getID());
        } else {
            System.out.println("Invalid salle.");
        }

    }

    public void RemoveSalle(List<Salle> salles, int ID){
        for (Salle salle : salles) {
            if (salle.getID() == ID) {
                salles.remove(salle);
                System.out.println("Salle deleted: " + salle.getID());
                return;
            }
        }
        System.out.println("Salle not found.");

    }

    public void ModifySalle(List<Salle> salles, Salle salle){
        System.out.println("What do you want to modify in the salle? :" + salle.getID());
        System.out.println("1. ID");
        System.out.println("2. Capacite");
        int choice;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                while (true) {
                    System.out.println("Enter the new ID: ");
                    int newID = sc.nextInt();
                    boolean found = false;
                    for (Salle s : salles) {
                        if (s.getID() == newID) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        salle.setID(newID);
                        System.out.println("ID modified. The new ID is: " + salle.getID());
                        break;
                    } else {
                        System.out.println("ID already exists. Please enter a different ID.");
                    }
                }
                int newID = sc.nextInt();
                salle.setID(newID);
                System.out.println("ID modified. The new ID is: " + salle.getID());
                break;
        
            case 2:
                System.out.println("Enter the new capacite: ");
                int newcapacite = sc.nextInt();
                salle.setCapacite(newcapacite);
                System.out.println("Capacite modified. The new capacite is: " + salle.getCapacite());
                break;
        }
        sc.close();

    }

    public void ReserveSalle(List<Salle> salles, Salle salle, Diffusion diffusion, Film film){
        for (Salle s : salles) {
            if (s.getID() == salle.getID()) {
                if (!s.isAvaible()) {
                    System.out.println("Salle already reserved.");
                    return;
                }else{
                    s.ReserveSalle();
                    System.out.println("Salle reserved: " + s.getID() + " for the movie: " + film.getTitle());
                    diffusion.setSalle(s);
                    diffusion.setFilm(film);
                    return;
                }
            }
        }
        System.out.println("Salle not found.");

    }
}
