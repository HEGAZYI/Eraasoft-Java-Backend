package CodeForces.W;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // عشان يدي نفس الشكل اللي انت كاتبه

        Shape3 dp = new Shape3();
        dp.printPattern(n);
    }
}

