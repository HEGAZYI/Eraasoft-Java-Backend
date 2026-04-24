package SheetP4;

import java.util.Scanner;

public class Difference {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long a = input.nextLong();
        long b = input.nextLong();
        long c = input.nextLong();
        long d = input.nextLong();

        CalculateDifference calc = new CalculateDifference();
        calc.calculate(a,b,c,d);

        input.close();
    }
}

class CalculateDifference {

    // we want to calculate this operation -> X=(A*B)-(C*D).
    public void calculate(long a, long b, long c, long d) {
        long difference = (a * b) - (c * d);
        System.out.println("Difference = "+difference);
    }
}
