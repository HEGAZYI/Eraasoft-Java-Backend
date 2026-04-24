package Q4;

public class Player {
    private int id;
    private String name;
    private int number;

    public Player(int id, String name, int number) {
        setId(id);
        setName(name);
        setNumber(number);
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Player ID must be > 0");
        }
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Player name cannot be empty");
        }
    }

    public void setNumber(int number) {
        if (number >= 0 && number <= 99) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("Player number must be between 0 and 99");
        }
    }

    public void printData() {
        System.out.println("Player Data:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Number: " + number);
    }
}

