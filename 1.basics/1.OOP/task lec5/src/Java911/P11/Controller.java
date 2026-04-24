package Java911.P11;

public class Controller extends Resturant{

    @Override
    public void showOrders(){
        System.out.println("Orders List:");

        for (int i = 0; i < count; i++) {
            System.out.println(orders[i]);
        }
    }
}
