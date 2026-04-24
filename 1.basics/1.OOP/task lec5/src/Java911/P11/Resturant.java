package Java911.P11;

public abstract class Resturant {

    String[] orders = new String[10];
    int count = 0;

    public void addOrder(String order) {
        orders[count++] = order;
        System.out.println("Order added: " + order);
    }

    public abstract void showOrders();
}
