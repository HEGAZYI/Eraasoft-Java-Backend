package Java911.P16;

public class Person {
    String name;
    Order order;

    Person(String name, Order order) {
        this.name = name;
        this.order = order;
    }

    void show() {
        System.out.println("Person: " + name);
        order.showOrder();
    }
}