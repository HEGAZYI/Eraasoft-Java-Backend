package Java911.P13;

public class Main {
    public static void main(String[] args) {

        Shirt s = new Shirt(10, "Red");
        Player p = new Player("Ahmed", s);

        p.show();
    }
}