package Java911.P11;

public class Main {
    public static void main(String[] args) {
        Controller app = new Controller();

        app.addOrder("Pizza");
        app.addOrder("Burger");

        app.showOrders();
    }
}
