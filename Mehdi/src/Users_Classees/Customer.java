package Users_Classees;

import java.util.List;
import java.util.Scanner;

import Basic_Classes.Diffusion;
import Basic_Classes.Film;
import Basic_Classes.Ticket;
import Basic_Classes.Caisse;

public class Customer extends User {
    
    public String getUsername() {
        return super.getusername();
    }

    private String email;
    private String phone;
    private int age;
    private int cardnumber;
    private int cardpass;
    Scanner sc = new Scanner(System.in);

    public Customer(String username, String password, String role, String email, String phone, int age, int cardnumber, int cardpass) {
        super(username, password, role);
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.cardnumber = cardnumber;
        this.cardpass = cardpass;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public int getCardnumber() {
        return cardnumber;
    }

    public int getCardpass() {
        return cardpass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setCardnumber(int cardnumber) {
        this.cardnumber = cardnumber;
    }

    public void setCardpass(int cardpass) {
        this.cardpass = cardpass;
    }

    public void WatchMovieList(List<Film> movies){
        for (Film film : movies) {
            System.out.println(film.toString());
        }

    }

    public void SellTicket(Ticket ticket, Caisse caisse) {
        if (ticket.isAvailable()) {
            ticket.setAvailable(false);
            caisse.IncrementCurrentamount((int) ticket.getPrice());
        }
    }

    public void CancelTicket(Ticket ticket, Caisse caisse) {
        if (ticket.getDiffusion().getDate().isBefore(new java.util.Date().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate())) {
            throw new IllegalArgumentException("You can't cancel a ticket for a diffusion that has already happened.");
        }else
            if (!ticket.isAvailable()) {
                ticket.setAvailable(true);
                caisse.DecrementCurrentamount((int) ticket.getPrice());
            }
    }

    public void SortMovieList(List<Film> movies, String Genre, int maxDuration, String Director, String AgeRestriction, String Language){
        if (Language == null && Genre == null && maxDuration == -1 && Director == null && AgeRestriction == null) {
            WatchMovieList(movies);
        }else{
            if(Language == null && Genre == null && maxDuration == -1 && Director == null && AgeRestriction != null){
                for (Film film : movies) {
                    if (film.getAgeRestriction().equals(AgeRestriction)) {
                        System.out.println(film.toString());
                    }
                }
            }else{ 
                if(Language == null && Genre == null && maxDuration == -1 && Director != null && AgeRestriction == null){
                    for (Film film : movies) {
                        if (film.getDirector().equals(Director)) {
                            System.out.println(film.toString());
                        }
                    }
                }else{
                    if(Language == null && Genre == null && maxDuration == -1 && Director != null && AgeRestriction != null){
                        for (Film film : movies) {
                            if (film.getDirector().equals(Director) && film.getAgeRestriction().equals(AgeRestriction)) {
                                System.out.println(film.toString());
                            }
                        }
                    }else{
                        if (Language == null && Genre == null && maxDuration != -1 && Director == null && AgeRestriction == null){
                            for (Film film : movies) {
                                if (film.getDuration() <= maxDuration) {
                                    System.out.println(film.toString());
                                }
                            }
                        }else{
                            if(Language == null && Genre == null && maxDuration != -1 && Director == null && AgeRestriction != null){
                                for (Film film : movies) {
                                    if (film.getDuration() <= maxDuration && film.getAgeRestriction().equals(AgeRestriction)) {
                                        System.out.println(film.toString());
                                    }
                                }
                            }else{
                                if(Language == null && Genre == null && maxDuration != -1 && Director != null && AgeRestriction == null){
                                    for (Film film : movies) {
                                        if (film.getDuration() <= maxDuration && film.getDirector().equals(Director)) {
                                            System.out.println(film.toString());
                                        }
                                    }
                                }else{
                                    if(Language == null && Genre == null && maxDuration != -1 && Director != null && AgeRestriction != null){
                                        for (Film film : movies) {
                                            if (film.getDuration() <= maxDuration && film.getDirector().equals(Director) && film.getAgeRestriction().equals(AgeRestriction)) {
                                                System.out.println(film.toString());
                                            }
                                        }
                                    }else{
                                        if(Language == null && Genre != null && maxDuration == -1 && Director == null && AgeRestriction == null){
                                            for (Film film : movies) {
                                                if (film.getGenre().equals(Genre)) {
                                                    System.out.println(film.toString());
                                                }
                                            }
                                        }else{
                                            if(Language == null && Genre != null && maxDuration == -1 && Director == null && AgeRestriction != null){
                                                for (Film film : movies) {
                                                    if (film.getGenre().equals(Genre) && film.getAgeRestriction().equals(AgeRestriction)) {
                                                        System.out.println(film.toString());
                                                    }
                                                }
                                            }else{
                                                if(Language == null && Genre != null && maxDuration == -1 && Director != null && AgeRestriction == null){
                                                    for (Film film : movies) {
                                                        if (film.getGenre().equals(Genre) && film.getDirector().equals(Director)) {
                                                            System.out.println(film.toString());
                                                        }
                                                    }
                                                }else{
                                                    if(Language == null && Genre != null && maxDuration == -1 && Director != null && AgeRestriction != null){
                                                        for (Film film : movies) {
                                                            if (film.getGenre().equals(Genre) && film.getDirector().equals(Director) && film.getAgeRestriction().equals(AgeRestriction)) {
                                                                System.out.println(film.toString());
                                                            }
                                                        }
                                                    }else{
                                                        if(Language == null && Genre != null && maxDuration != -1 && Director == null && AgeRestriction == null){
                                                            for (Film film : movies) {
                                                                if (film.getGenre().equals(Genre) && film.getDuration() <= maxDuration) {
                                                                    System.out.println(film.toString());
                                                                }
                                                            }
                                                        }else{
                                                            if (Language == null && Genre != null && maxDuration != -1 && Director == null && AgeRestriction != null){
                                                                for (Film film : movies) {
                                                                    if (film.getGenre().equals(Genre) && film.getDuration() <= maxDuration && film.getAgeRestriction().equals(AgeRestriction)) {
                                                                        System.out.println(film.toString());
                                                                    }
                                                                }
                                                                
                                                            }else{
                                                                if(Language == null && Genre != null && maxDuration != -1 && Director != null && AgeRestriction == null){
                                                                    for (Film film : movies) {
                                                                        if (film.getGenre().equals(Genre) && film.getDuration() <= maxDuration && film.getDirector().equals(Director)) {
                                                                            System.out.println(film.toString());
                                                                        }
                                                                    }
                                                                }else{
                                                                    if(Language == null && Genre != null && maxDuration != -1 && Director != null && AgeRestriction != null){
                                                                        for (Film film : movies) {
                                                                            if (film.getGenre().equals(Genre) && film.getDuration() <= maxDuration && film.getDirector().equals(Director) && film.getAgeRestriction().equals(AgeRestriction)) {
                                                                                System.out.println(film.toString());
                                                                            }
                                                                        }
                                                                    }else{
                                                                        if (Language != null && Genre == null && maxDuration == -1 && Director == null && AgeRestriction == null) {
                                                                            WatchMovieList(movies);
                                                                        } else {
                                                                            if(Language != null && Genre == null && maxDuration == -1 && Director == null && AgeRestriction != null){
                                                                                for (Film film : movies) {
                                                                                    if (film.getAgeRestriction().equals(AgeRestriction)) {
                                                                                        System.out.println(film.toString());
                                                                                    }
                                                                                }
                                                                            }else{ 
                                                                                if(Language != null && Genre == null && maxDuration == -1 && Director != null && AgeRestriction == null){
                                                                                    for (Film film : movies) {
                                                                                        if (film.getDirector().equals(Director)) {
                                                                                            System.out.println(film.toString());
                                                                                        }
                                                                                    }
                                                                                }else{
                                                                                    if(Language != null && Genre == null && maxDuration == -1 && Director != null && AgeRestriction != null){
                                                                                        for (Film film : movies) {
                                                                                            if (film.getDirector().equals(Director) && film.getAgeRestriction().equals(AgeRestriction)) {
                                                                                                System.out.println(film.toString());
                                                                                            }
                                                                                        }
                                                                                    }else{
                                                                                        if (Language != null && Genre == null && maxDuration != -1 && Director == null && AgeRestriction == null){
                                                                                            for (Film film : movies) {
                                                                                                if (film.getDuration() <= maxDuration) {
                                                                                                    System.out.println(film.toString());
                                                                                                }
                                                                                            }
                                                                                        }else{
                                                                                            if(Language != null && Genre == null && maxDuration != -1 && Director == null && AgeRestriction != null){
                                                                                                for (Film film : movies) {
                                                                                                    if (film.getDuration() <= maxDuration && film.getAgeRestriction().equals(AgeRestriction)) {
                                                                                                        System.out.println(film.toString());
                                                                                                    }
                                                                                                }
                                                                                            }else{
                                                                                                if(Language != null && Genre == null && maxDuration != -1 && Director != null && AgeRestriction == null){
                                                                                                    for (Film film : movies) {
                                                                                                        if (film.getDuration() <= maxDuration && film.getDirector().equals(Director)) {
                                                                                                            System.out.println(film.toString());
                                                                                                        }
                                                                                                    }
                                                                                                }else{
                                                                                                    if(Language != null && Genre == null && maxDuration != -1 && Director != null && AgeRestriction != null){
                                                                                                        for (Film film : movies) {
                                                                                                            if (film.getDuration() <= maxDuration && film.getDirector().equals(Director) && film.getAgeRestriction().equals(AgeRestriction)) {
                                                                                                                System.out.println(film.toString());
                                                                                                            }
                                                                                                        }
                                                                                                    }else{
                                                                                                        if(Language != null && Genre != null && maxDuration == -1 && Director == null && AgeRestriction == null){
                                                                                                            for (Film film : movies) {
                                                                                                                if (film.getGenre().equals(Genre)) {
                                                                                                                    System.out.println(film.toString());
                                                                                                                }
                                                                                                            }
                                                                                                        }else{
                                                                                                            if(Language != null && Genre != null && maxDuration == -1 && Director == null && AgeRestriction != null){
                                                                                                                for (Film film : movies) {
                                                                                                                    if (film.getGenre().equals(Genre) && film.getAgeRestriction().equals(AgeRestriction)) {
                                                                                                                        System.out.println(film.toString());
                                                                                                                    }
                                                                                                                }
                                                                                                            }else{
                                                                                                                if(Language != null && Genre != null && maxDuration == -1 && Director != null && AgeRestriction == null){
                                                                                                                    for (Film film : movies) {
                                                                                                                        if (film.getGenre().equals(Genre) && film.getDirector().equals(Director)) {
                                                                                                                            System.out.println(film.toString());
                                                                                                                        }
                                                                                                                    }
                                                                                                                }else{
                                                                                                                    if(Language != null && Genre != null && maxDuration == -1 && Director != null && AgeRestriction != null){
                                                                                                                        for (Film film : movies) {
                                                                                                                            if (film.getGenre().equals(Genre) && film.getDirector().equals(Director) && film.getAgeRestriction().equals(AgeRestriction)) {
                                                                                                                                System.out.println(film.toString());
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }else{
                                                                                                                        if(Language != null && Genre != null && maxDuration != -1 && Director == null && AgeRestriction == null){
                                                                                                                            for (Film film : movies) {
                                                                                                                                if (film.getGenre().equals(Genre) && film.getDuration() <= maxDuration) {
                                                                                                                                    System.out.println(film.toString());
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }else{
                                                                                                                            if (Language != null && Genre != null && maxDuration != -1 && Director == null && AgeRestriction != null){
                                                                                                                                for (Film film : movies) {
                                                                                                                                    if (film.getGenre().equals(Genre) && film.getDuration() <= maxDuration && film.getAgeRestriction().equals(AgeRestriction)) {
                                                                                                                                        System.out.println(film.toString());
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                
                                                                                                                            }else{
                                                                                                                                if(Language != null && Genre != null && maxDuration != -1 && Director != null && AgeRestriction == null){
                                                                                                                                    for (Film film : movies) {
                                                                                                                                        if (film.getGenre().equals(Genre) && film.getDuration() <= maxDuration && film.getDirector().equals(Director)) {
                                                                                                                                            System.out.println(film.toString());
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }else{
                                                                                                                                    if(Language != null && Genre != null && maxDuration != -1 && Director != null && AgeRestriction != null){
                                                                                                                                        for (Film film : movies) {
                                                                                                                                            if (film.getGenre().equals(Genre) && film.getDuration() <= maxDuration && film.getDirector().equals(Director) && film.getAgeRestriction().equals(AgeRestriction)) {
                                                                                                                                                System.out.println(film.toString());
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }    
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }        
        
    
    
    public void bookTicket(List<Ticket> tickets, List<Diffusion> diffusions, List<Film> movies, double price, Customer customer){
        String choice;
        int nbrTickets;
        int j = 0;
        WatchMovieList(movies);
        System.out.println("For which movie do you want to book a ticket ? Please enter the title :");
        choice = sc.next();
        System.out.println("How many tickets do you want to book ?");
        nbrTickets = sc.nextInt();
        for (Film film : movies) {
            if (film.getTitle().equals(choice)) {
                if ((film.getAgeRestriction() == "Under_10" && customer.getAge() < 10) || (film.getAgeRestriction() == "Under_12" && customer.getAge() < 12) || (film.getAgeRestriction() == "Under_16" && customer.getAge() < 16) || (film.getAgeRestriction() == "Under_18" && customer.getAge() < 18)) {
                    System.out.println("Sorry, but you aren't old enough to watch this movie :" + film.getTitle());
                } else {
                    for (Diffusion diffusion : diffusions) {
                        if (diffusion.getFilm().getTitle().equals(choice)) {
                            if (diffusion.getSalle().getnbrAvaibleSeats() > nbrTickets) {
                                j++;
                                System.out.println(j +"- Available seats for " + diffusion.toString());
                            }    
                        }
                    }
                }
            }
        }
        System.out.println("For which diffusion do you want to book a ticket ? Please enter the number :");
        int choice1 = sc.nextInt();
        int i = 0;
        for (Diffusion diffusion : diffusions) {
            if (diffusion.getFilm().getTitle().equals(choice)) {
                i++;
                if (i == choice1) {
                    diffusion.DisplayAvaibleSeats();
                    for (int k = 0; k < nbrTickets; k++) {
                        System.out.println("For which seat do you want to book a ticket ? Please enter the number :");
                        int choice2 = sc.nextInt();
                        for (Ticket ticket : tickets) {
                            if (ticket.getDiffusion().equals(diffusion) && ticket.getSeat() == choice2) {
                                ticket.setCustomerID(customer.getUsername());
                                ticket.setPrice(price);
                                ticket.setAvailable(false);
                                System.out.println("Ticket booked for seat number " + choice2 + " for the movie " + choice + " at " + diffusion.getTime1() + " " + diffusion.getTime2() + " on " + diffusion.getDate() + " for " + price + "DZA");
                            }
                        }
                    }
                }
            }
        }
    }



}
