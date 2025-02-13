package Basic_Classes;

public class Salle {

    private int ID;
    private int capacite;
    private String type;

    public Salle(int ID, int capacite, String type) {
        this.ID = ID;
        this.capacite = capacite;
        this.type = type;
    }

    public int getID() {
        return ID;
    }

    public int getCapacite() {
        return capacite;
    }

    public String getType() {
        return type;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "ID=" + ID +
                ", capacite=" + capacite +
                ", type='" + type + '\'' +
                '}';
    }

}
