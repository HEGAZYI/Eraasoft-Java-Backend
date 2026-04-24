package Java911.P18.Pack1;

public class PlayerBenfit extends Player {
    protected String benfitPlayer;
    String allPlayerBenfit;

    public PlayerBenfit(int id, String name, int number, String benfit, String allBenfit) {
        super(id, name, number);
        this.benfitPlayer = benfit;
        this.allPlayerBenfit = allBenfit;
    }
}