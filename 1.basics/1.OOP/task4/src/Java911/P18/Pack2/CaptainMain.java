package Java911.P18.Pack2;

public class CaptainMain extends CaptainBenfit {

    public CaptainMain(int id, String name, boolean active, String benfit, String allBenfit) {
        super(id, name, active, benfit, allBenfit);
    }

    void show() {
        System.out.println("ID: " + id);
        System.out.println("Benefit: " + benfitCaptain);
        System.out.println("All Benefits: " + allCaptainBenfit);
    }

    public static void main(String[] args) {
        CaptainMain c = new CaptainMain(1,"Mr.Ahmed",true,"Leadership","Teamwork");
        c.show();
    }
}