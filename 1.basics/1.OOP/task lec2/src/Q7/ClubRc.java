package Q7;

public class ClubRc extends Player{

    private String rcode;

    public ClubRc(int id, String name, int number, String rcode) {
        super(id, name, number);
        this.rcode = rcode;
    }

    public void printWithCode() {
        printPlayerInfo();
        System.out.println("Rcode: " + rcode);
    }
}
