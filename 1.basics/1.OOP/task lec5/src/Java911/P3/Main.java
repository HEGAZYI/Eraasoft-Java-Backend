package Java911.P3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        Sum sum = new Sum(num1, num2, num3);
        int result = sum.calculateSum();
        System.out.println(result);
    }
}
