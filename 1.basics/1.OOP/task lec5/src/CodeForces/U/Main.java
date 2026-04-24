package CodeForces.U;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        SumCalculation calc = new SumCalculation();

        int result = calc.calculate(n, a, b);

        System.out.println(result);
    }
}

