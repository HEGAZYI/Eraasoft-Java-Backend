package Task7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter age: ");
            int age = sc.nextInt();

            CustomException.checkAge(age);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
