package Q5;

public class Player extends ShareData {
    private int number;

    public Player(int id, String name, String phone, int number) {
        super(id, name, phone);
        setNumber(number);
    }

    public void setNumber(int number) {
        if (number >= 0 && number <= 99) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("Number must be between 0 and 99");
        }
    }

    public void printPlayer() {
        printShareData();
        System.out.println("Number: " + number);
    }
}
