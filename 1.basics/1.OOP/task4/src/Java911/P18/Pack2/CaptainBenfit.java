package Java911.P18.Pack2;

public class CaptainBenfit extends Captain {
    protected String benfitCaptain;
    String allCaptainBenfit;

    public CaptainBenfit(int id, String name, boolean active, String benfit, String allBenfit) {
        super(id, name, active);
        this.benfitCaptain = benfit;
        this.allCaptainBenfit = allBenfit;
    }
}