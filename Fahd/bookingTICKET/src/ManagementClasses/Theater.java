package ManagementClasses;

public class Theater {

    public int NormalCapacity;
    public int TheaterId;
    public int VipCapacity;
    public Boolean Available;
    public int TotalPlaces;
    public int NormalReservedPlaces = 0;
    public int VipReservedPlaces = 0;

    public Theater(int NormalCapacity, int VipCapacity, int TheaterId, Boolean Available) {
        this.NormalCapacity = NormalCapacity;
        this.TheaterId = TheaterId;
        this.VipCapacity = VipCapacity;
        this.Available = Available;

        this.TotalPlaces = NormalCapacity + VipCapacity;
    }

}
