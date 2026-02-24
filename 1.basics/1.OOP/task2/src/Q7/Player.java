package Q7;

public class Player {

    protected int id;
    protected String name;
    protected int number;

    public Player(int id, String name, int number) {
        setId(id);
        setName(name);
        setNumber(number);
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("ID must be > 0");
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public void setNumber(int number) {
        if (number >= 0) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("Number must be >= 0");
        }
    }

    public void printPlayerInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Number: " + number);
    }
}
