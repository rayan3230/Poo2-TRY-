package ManagementClasses;

public class Theater {

    public int NormalCapacity;
    public int TheaterId;
    public int VipCapacity;
    public Boolean Available;
    public int TotalPlaces;

    public Theater(int NormalCapacity, int TheaterId, int VipCapacity, Boolean Available) {
        this.NormalCapacity = NormalCapacity;
        this.TheaterId = TheaterId;
        this.VipCapacity = VipCapacity;
        this.Available = Available;

        this.TotalPlaces = NormalCapacity + VipCapacity;
    }

}
