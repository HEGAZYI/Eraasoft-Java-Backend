package Java911.P16;

public class Order {
    Food[] foods = new Food[10];
    int foodCount = 0;

    Bill bill;
    Gift gift;

    void addFood(Food f) {
        foods[foodCount++] = f;
    }

    void calculateBill() {
        double total = 0;
        for (int i = 0; i < foodCount; i++) {
            total += foods[i].price;
        }
        bill = new Bill(total);
    }

    void addGift(Gift g) {
        gift = g;
    }

    void showOrder() {
        System.out.println("Order Details:");
        for (int i = 0; i < foodCount; i++) {
            System.out.println("- " + foods[i].name + " $" + foods[i].price);
        }
        if (gift != null) {
            System.out.println("Gift: " + gift.description);
        }
        if (bill != null) {
            bill.show();
        }
    }
}