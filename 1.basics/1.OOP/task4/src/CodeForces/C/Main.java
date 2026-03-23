package CodeForces.C;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        NumbersChecker checker = new NumbersChecker();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            checker.processNumber(num);
        }

        checker.printResult();
    }
}


