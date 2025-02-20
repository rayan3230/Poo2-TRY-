package Basic_Classes;


public class Caisse {

    private int currentamount = 0;

    public int getCurrentamount() {
        return currentamount;
    }

    public void setCurrentamount(int currentamount) {
        this.currentamount = currentamount;
    }

    public void SeeCurrentamount() {
        System.out.println("The current amount is: " + this.currentamount + " DZA.");
    }

    public void IncrementCurrentamount(int amount) {
        this.currentamount += amount;
    }

    public void DecrementCurrentamount(int amount) {
        if (this.currentamount < amount) {
            System.out.println("The amount is not enough.");
            return;
        }else {
            this.currentamount -= amount;
        }
    }

     
}      
