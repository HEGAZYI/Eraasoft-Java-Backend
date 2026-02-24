package Q7;

public class ClubFc extends Player{
    private String fcode;

    public ClubFc(int id, String name, int number, String fcode) {
        super(id, name, number);
        this.fcode = fcode;
    }

    public void printWithCode() {
        printPlayerInfo();
        System.out.println("Fcode: " + fcode);
    }
}
