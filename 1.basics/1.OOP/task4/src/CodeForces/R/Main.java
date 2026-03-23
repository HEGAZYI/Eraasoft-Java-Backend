package CodeForces.R;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SequenceCalculator calc = new SequenceCalculator();

        while (true) {

            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a <= 0 || b <= 0)
                break;

            calc.printSequence(a, b);
        }
    }
}

