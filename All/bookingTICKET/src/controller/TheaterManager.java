package controller;

import Model.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TheaterManager {

    public ArrayList<Theater> theaters;

    public TheaterManager() {

        this.theaters = new ArrayList<>();

        Theater Room1 = new Theater(0, 200, 40, 1, true);
        Theater Room2 = new Theater(1, 300, 60, 2, true);
        Theater Room3 = new Theater(2, 400, 80, 3, true);
        Theater Room4 = new Theater(3, 200, 40, 4, true);
        Theater Room5 = new Theater(4, 300, 60, 5, true);
        Theater Room6 = new Theater(5, 200, 40, 6, true);
        Theater Room7 = new Theater(6, 200, 40, 7, true);

        AddTheater(Room1);
        AddTheater(Room2);
        AddTheater(Room3);
        AddTheater(Room4);
        AddTheater(Room5);
        AddTheater(Room6);
        AddTheater(Room7);
    }

    public void AddTheater(Theater theater) {
        theaters.add(theater);
    }

    public void setTheaterUnAvailable(int theaterId) {
        theaters.get(theaterId).isAvailable = false;
    }

    public void setTheaterAvailable(int theaterId) {
        theaters.get(theaterId).isAvailable = true;
    }

    public void DisplayTheater(){
        for(Theater theater : theaters){
            System.out.println("---------------------------------");
            System.out.println("Theater ID: " + theater.TheaterId);
            System.out.println("Total Places: " + theater.TotalPlaces);
            System.out.println("Normal Capacity: " + theater.NormalCapacity);
            System.out.println("Vip Capacity: " + theater.VipCapacity);
            System.out.println("Availability: " + theater.isAvailable);
            System.out.println("Normal Reserved Places: " + theater.NormalReservedPlaces);
            System.out.println("Vip Reserved Places: " + theater.VipReservedPlaces);
            System.out.println("---------------------------------");
        }
    }

    public void addTheater(int theaterId, int totalPlaces, int normalCapacity, int vipCapacity) {
        String sql = "INSERT INTO theaters (TheaterID, TotalPlaces, NormalCapacity, VipCapacity) VALUES (?, ?, ?, ?)";

        try(Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, theaterId);
            pstmt.setInt(2, totalPlaces);
            pstmt.setInt(3, normalCapacity);
            pstmt.setInt(4, vipCapacity);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new theater was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteTheater(int theaterID){
        String sql = "DELETE FROM theaters WHERE TheaterID = ?";

        try(Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, theaterID);

            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Theater deleted successfully!");
            } else {
                System.out.println("Theater not found. No delete performed.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void modifyTheaterCapacity(int theaterID, int NewnormalCapacity, int NewvipCapacity) {
        String sql = "UPDATE theaters SET NormalCapacity = ?, VipCapacity = ?, TotalPlaces = ? WHERE TheaterID = ?";
        int TotalPlaces = NewnormalCapacity + NewvipCapacity;

        try(Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, NewnormalCapacity);
            pstmt.setInt(2, NewvipCapacity);
            pstmt.setInt(3, TotalPlaces);

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Theater updated successfully!");
            } else {
                System.out.println("Theater not found. No update performed.");
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
