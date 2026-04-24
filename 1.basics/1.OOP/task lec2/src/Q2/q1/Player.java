package Q2.q1;

public class Player {
    private int number;
    private String name;

    public Player(int number, String name) {
        setNumber(number);
        setName(name);
    }

    public Player() {}

    // A method to set number of the player
    public void setNumber(int number) {
        if (number > 0) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("Number must be greater than 0");
        }
    }

    // A method to set name of the player
    public void setName(String name) {
        if (name != null && name.length() > 5) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name length must be greater than 5 characters");
        }
    }

    // A method to print player data
    public void printPlayer() {
        System.out.println("Player Number: " + number);
        System.out.println("Player Name: " + name);
    }
}
