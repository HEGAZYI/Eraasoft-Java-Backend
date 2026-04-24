package SheetP3;


import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long a = input.nextLong();
        long b = input.nextLong();

        Calculator calculator = new Calculator();
        calculator.operations(a,b);


        input.close();
    }
}

class Calculator{

    public void operations(long a,long b){
        System.out.println(a + " + "  + b + " = "  + (a + b));
        System.out.println(a + " * "  + b + " = "  + (a * b));
        System.out.println(a + " - "  + b + " = "  + (a - b));
    }
}