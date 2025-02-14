package Basic_Classes;


import java.time.LocalDate;
import java.time.LocalTime;

public class Diffusion {

    private static int diffusioncounter = 0;
    private int IDdiffusion;
    private Salle salle;
    private Film film;
    private int day;
    private int month;
    private int year;
    private int hour1;
    private int minute1;
    private int hour2;
    private int minute2;
    LocalDate date = LocalDate.of(this.year, this.month, this.day);
    LocalTime time1 = LocalTime.of(this.hour1, this.minute1);
    LocalTime time2 = LocalTime.of(this.hour2, this.minute2);

    public Diffusion(Salle salle, Film film, LocalDate date, LocalTime time1) {
        this.IDdiffusion = diffusioncounter + 1;
        this.salle = salle;
        this.film = film;
        this.date = date;
        this.time1 = time1;
        if (this.minute1 + film.duration % 60 > 60) {

            this.minute2 = this.minute1 - 60 + film.duration % 60;
            this.hour2 = this.hour1 + film.duration / 60 + 1;
    
        } else {
    
            this.minute2 = this.minute1 + film.duration % 60;
            this.hour2 = this.hour1 + film.duration / 60;
        }
    }

    public int getIDdiffusion() {
        return IDdiffusion;
    }

    public Salle getSalle() {
        return salle;
    }

    public Film getFilm() {
        return film;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime1() {
        return time1;
    }

    public LocalTime getTime2() {
        return time2;
    }

    public void setIDdiffusion(int IDdiffusion) {
        this.IDdiffusion = IDdiffusion;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime1(LocalTime time1) {
        this.time1 = time1;
    }


    @Override
    public String toString(){

        return "Diffusion{" +
                ", salle=" + salle +
                ", film=" + film +
                ", date=" + date +
                ", time1=" + time1 +
                ", time2=" + time2 +
                '}';
    }


}
