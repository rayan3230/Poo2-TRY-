package model;
import java.util.ArrayList;
import java.util.List;


public class theater {
    public class Theater {
        private List<seat> seats;
        private List<vipseat> vipSeats;

        public Theater() {
            this.seats = new ArrayList<>();
            this.vipSeats = new ArrayList<>();
        }

        public void addSeat(seat seat) {
            seats.add(seat);
        }

        public void addVipSeat(vipseat vipSeat) {
            vipSeats.add(vipSeat);
        }

        public List<seat> getSeats() {
            return seats;
        }

        public List<vipseat> getVipSeats() {
            return vipSeats;
        }
    }
}
