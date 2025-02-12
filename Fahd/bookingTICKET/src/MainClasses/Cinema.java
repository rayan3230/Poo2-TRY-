package MainClasses;

import ManagementClasses.*;
import Personnel.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {

    public ArrayList<Movie> movies;
    public ArrayList<Admin> admins;
    public ArrayList<Theater> theaters;

    public Cinema() {

        this.movies = new ArrayList<Movie>();
        this.admins = new ArrayList<Admin>();
        this.theaters = new ArrayList<Theater>();
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

}
