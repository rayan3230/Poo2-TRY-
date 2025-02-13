package Controller;

import Moodle.Hall;
import java.util.ArrayList;


public class GestionHall {

    public ArrayList<Hall> Salles = new ArrayList<Hall>();
    public int NbrHalls = 0;

    public void addHall(String nameHall,int seat , int VipSeat) {
        NbrHalls++;
        Hall hall = new Hall(NbrHalls, nameHall, seat, VipSeat);
        hall.seatAvailable = true;
        hall.Vipavailable = true;
        Salles.add(hall);

    }

    public void ModifierHall(int HallId , String nameHall , int NewVipSeat , int NewSeat){
        if(Salles.get(HallId) != null){
            Salles.get(HallId).VipSeat = NewVipSeat;
            Salles.get(HallId).seat = NewSeat;
            return ;
        }else{
            System.out.println("Hall Id is null");
        }
    }

    public void SuprimmerHall(int HallId ){
        if(Salles.get(HallId) != null){
            System.out.println("Hall : " + Salles.get(HallId).NameHall + " Deleted ");
            Salles.remove(HallId);
            NbrHalls--;
            return ;
        }else{
            System.out.println("Hall Id is null");
        }
    }

    public void ReserveSimpleSeat(int Salleid){
        if(Salles.get(Salleid) != null && Salles.get(Salleid).seatAvailable){
            Salles.get(Salleid).seat--;
            if(Salles.get(Salleid).seat == 0){
                Salles.get(Salleid).seatAvailable = false;
            }
            
            System.out.println("Simple Seat Reserved in Hall : " + Salles.get(Salleid).NameHall);
        }else{
            System.out.println("Simple Seat not available or Hall Id is null");
        }

    }
    
    public void ReserveVipSeat(int Salleid){
        if(Salles.get(Salleid) != null && Salles.get(Salleid).Vipavailable){
            Salles.get(Salleid).VipSeat--;
            if(Salles.get(Salleid).VipSeat == 0){
                Salles.get(Salleid).Vipavailable = false;
            }
            
            System.out.println("Vip Seat Reserved in Hall : " + Salles.get(Salleid).NameHall);
        }else{
            System.out.println("Vip Seat not available or Hall Id is null");
        }
    }

    public void SimpleSeatRemaining(int idsalle){
        if(Salles.get(idsalle)!= null){
            System.out.println("Simple Seat remaining in Hall : " + Salles.get(idsalle).NameHall + " : " + Salles.get(idsalle).seat);
        }else{
            System.out.println("Hall Id is null");
        }
    }
    
    public void VipSeatRemaining(int idsalle){
        if(Salles.get(idsalle)!= null){
            System.out.println("Vip Seat remaining in Hall : " + Salles.get(idsalle).NameHall + " : " + Salles.get(idsalle).VipSeat);
        }else{
            System.out.println("Hall Id is null");
        }
    }

    public void Displayhall(){
        for(Hall hall : Salles){
            System.out.println("Hall : " + hall.NameHall + " Seat : " + hall.seat + " Vip Seat : " + hall.VipSeat);
        }
    }
    

}
