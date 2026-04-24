package CodeForces.Q;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        Digits dp = new Digits();

        while (t-- > 0) {
            String n = sc.next();
            dp.printDigits(n);
        }
    }
}

