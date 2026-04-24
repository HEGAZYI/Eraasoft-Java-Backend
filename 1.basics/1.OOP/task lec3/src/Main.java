
import K.MaxAndMin;
import L.Brothers;
import M.CapOrSmallOrDigit;
import N.Char;
import O.Calculator;

import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        Calculator calc = new Calculator(input);
        System.out.println(calc.compute());

        sc.close();
    }
}
