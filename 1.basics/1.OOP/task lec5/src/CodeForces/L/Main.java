package CodeForces.L;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        GCD gcd = new GCD();

        int result = gcd.calculate(a, b);

        System.out.println(result);
    }
}

