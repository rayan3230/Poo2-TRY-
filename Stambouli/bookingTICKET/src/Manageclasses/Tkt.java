package Manageclasses;
public class Tkt {

        private int number;
        public Movie movie;
        private TicketType type;
        private String date;

    

    public Tkt(String date, Movie movie, int number, TicketType type) {
        this.date = date;
        this.movie = movie;
        this.number = number;
        this.type = type;
    }
    
        public enum TicketType {
            VIP, Normal
        }
    
        public void Ticket(int number, TicketType type, String date, Movie movie) {
            setNumber(number);
            setType(type);
            setDate(date);
            setMovie(movie);
        }
    
        public int getNumber() {
            return number;
        }
    
        public Movie getMovie() {
            return movie;
        }
    
        public TicketType getType() {
            return type;
        }
    
        public String getDate() {
            return date;
        }
    
        public void setNumber(int number) {
            if (number > 0) {
                this.number = number;
            } else {
                throw new IllegalArgumentException("Ticket number must be positive.");
            }
        }
    
        public void setMovie(Movie movie) {
            if (movie != null) {
                this.movie = movie;
            } else {
                throw new IllegalArgumentException("Movie cannot be null.");
            }
        }
    
        public void setType(TicketType type) {
            if (type != null) {
                this.type = type;
            } else {
                throw new IllegalArgumentException("Invalid ticket type.");
            }
        }
    
        public void setDate(String date) {
            if (date != null && !date.trim().isEmpty()) {
                this.date = date;
            } else {
                throw new IllegalArgumentException("Date cannot be empty.");
            }
        }
    
        @Override
        public String toString() {
            return "Ticket #" + number + "\n" +
                   " Movie: " + movie.getTitle() + "\n" +
                   "Date: " + date + "\n" +
                   "Type: " + type;
        }
    }
    

