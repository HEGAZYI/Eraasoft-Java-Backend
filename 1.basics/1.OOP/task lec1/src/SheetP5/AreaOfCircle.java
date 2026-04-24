package SheetP5;

import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        float R = input.nextFloat();


        Circle circle = new Circle();
        circle.area(R);


        input.close();
    }
}

class Circle {
    final double PI= 3.141592653;
    public void area(double r) {
        double area = PI * Math.pow(r,2);

        System.out.println(area);
    }

}
