package Java911.P16;

public class Main {
    public static void main(String[] args) {

        Food f1 = new Food("Pizza", 12.5);
        Food f2 = new Food("Burger", 8.0);

        Gift g = new Gift("Free Drink");

        Order order = new Order();
        order.addFood(f1);
        order.addFood(f2);
        order.addGift(g);
        order.calculateBill();

        Person p = new Person("Ahmed", order);

        p.show();
    }
}