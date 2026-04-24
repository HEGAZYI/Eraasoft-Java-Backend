package Java911.P18;

import Java911.P18.Pack1.PlayerBenfit;

public class PlayerOutside extends PlayerBenfit {
    public PlayerOutside(int id, String name, int number, String benfit, String allBenfit) {
        super(id, name, number, benfit, allBenfit);
    }

    void show() {
        System.out.println("ID: " + id);
        System.out.println("Benefit: " + benfitPlayer);
    }

    public static void main(String[] args) {
        PlayerOutside p = new PlayerOutside(2,"Ali",9,"Strong","Teamwork");
        p.show();
    }
}