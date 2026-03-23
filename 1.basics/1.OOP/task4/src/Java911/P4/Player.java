package Java911.P4;

public class Player extends EntityClass{
    private int number;

    public Player(int id , String name, int number) {
        super(id , name);
        setNumber(number);
    }

    private void setNumber(int number) {
        if (number >= 0 && number <= 99) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("Player number must be between 0 and 99");
        }
    }

    public void printPlayer(){
        printBasicData();
        System.out.println("number: " + number);
    }
}
