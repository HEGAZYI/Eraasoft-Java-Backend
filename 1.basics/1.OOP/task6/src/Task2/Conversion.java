package Task2;

import java.util.Scanner;

public class Conversion {
    public static void convert() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            String input = sc.nextLine();
            int num = Integer.parseInt(input);
            System.out.println("Converted number = " + num);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format!");
        }
    }
}
