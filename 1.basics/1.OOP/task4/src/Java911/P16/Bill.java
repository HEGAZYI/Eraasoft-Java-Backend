package Java911.P16;

public class Bill {
    double total;

    Bill(double total) {
        this.total = total;
    }

    void show() {
        System.out.println("Total Bill: $" + total);
    }
}