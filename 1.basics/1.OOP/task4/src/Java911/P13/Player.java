package Java911.P13;

public class Player {
    String name;
    Shirt shirt;

    Player(String name, Shirt shirt) {
        this.name = name;
        this.shirt = shirt;
    }

    void show() {
        System.out.println("Player: " + name);
        System.out.println("Shirt Number: " + shirt.number);
        System.out.println("Color: " + shirt.color);
    }
}