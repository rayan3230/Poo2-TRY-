package Controller;

import Moodle.Hall;
import java.util.ArrayList;


public class GestionHall {
    public ArrayList<Hall> halls = new ArrayList<>();
    public int hallCount = 0;

    public void addHall(String hallNameHall, int regularSeats, int vipSeats) {
        hallCount++;
        Hall hall = new Hall(hallCount, hallNameHall, regularSeats, vipSeats);
        halls.add(hall);
    }



    public void modifyHall(int hallId, String hallNameHall, int newVipSeats, int newSeats) {
        if(halls.get(hallId) != null) {
            halls.get(hallId).totalVipSeats = newVipSeats;
            halls.get(hallId).totalRegularSeats = newSeats;
            halls.get(hallId).NameHall = hallNameHall;
        } else {
            System.out.println("Hall Id is null");
        }
    }

    public void SuprimmerHall(int HallId) {
        if(halls.get(HallId) != null) {
            System.out.println("Hall : " + halls.get(HallId).NameHall + " Deleted ");
            halls.remove(HallId);
            hallCount--;
        } else {
            System.out.println("Hall Id is null");
        }
    }

    public void ReserveSimpleSeat(int Salleid) {
        if(halls.get(Salleid) != null && halls.get(Salleid).regularSeatsAvailable) {
            halls.get(Salleid).totalRegularSeats--;
            if(halls.get(Salleid).totalRegularSeats == 0) {
                halls.get(Salleid).regularSeatsAvailable = false;
            }
            System.out.println("Simple Seat Reserved in Hall : " + halls.get(Salleid).NameHall);
        } else {
            System.out.println("Simple Seat not available or Hall Id is null");
        }
    }
    
       public void ReserveVipSeat(int Salleid) {
        if(halls.get(Salleid) != null && halls.get(Salleid).vipSeatsAvailable) {
            halls.get(Salleid).totalVipSeats--;
            if(halls.get(Salleid).totalVipSeats == 0) {
                halls.get(Salleid).vipSeatsAvailable = false;
            }
            System.out.println("Vip Seat Reserved in Hall : " + halls.get(Salleid).NameHall);
        } else {
            System.out.println("Vip Seat not available or Hall Id is null");
        }
    }

    public void SimpleSeatRemaining(int idsalle) {
        if(halls.get(idsalle) != null) {
            System.out.println("Simple Seat remaining in Hall : " + halls.get(idsalle).NameHall + " : " + halls.get(idsalle).totalRegularSeats);
        } else {
            System.out.println("Hall Id is null");
        }
    }
    
    public void VipSeatRemaining(int idsalle) {
        if(halls.get(idsalle) != null) {
            System.out.println("Vip Seat remaining in Hall : " + halls.get(idsalle).NameHall + " : " + halls.get(idsalle).totalVipSeats);
        } else {
            System.out.println("Hall Id is null");
        }
    }



  

}
