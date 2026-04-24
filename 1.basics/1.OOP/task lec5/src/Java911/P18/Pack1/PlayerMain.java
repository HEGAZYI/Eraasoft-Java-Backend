package Java911.P18.Pack1;

public class PlayerMain extends PlayerBenfit {
    public PlayerMain(int id, String name, int number, String benfit, String allBenfit) {
        super(id, name, number, benfit, allBenfit);
    }

    void show() {
        System.out.println("ID: " + id);
        System.out.println("Benefit: " + benfitPlayer);
        System.out.println("All Benefits: " + allPlayerBenfit);
    }

    public static void main(String[] args) {
        PlayerMain p = new PlayerMain(1,"Ahmed",10,"Fast","Teamwork");
        p.show();
    }
}