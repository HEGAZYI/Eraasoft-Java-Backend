package Java911.P18;

import Java911.P18.Pack2.CaptainBenfit;

public class CaptainOutside extends CaptainBenfit {
    public CaptainOutside(int id, String name, boolean active, String benfit, String allBenfit) {
        super(id, name, active, benfit, allBenfit);
    }

    void show() {
        System.out.println("ID: " + id);
        System.out.println("Benefit: " + benfitCaptain);
    }

    public static void main(String[] args) {
        CaptainOutside c = new CaptainOutside(2,"Mr.Ali",false,"Smart","Teamwork");
        c.show();
    }
}