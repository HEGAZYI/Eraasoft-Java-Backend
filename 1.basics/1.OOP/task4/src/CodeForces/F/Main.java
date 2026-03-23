package CodeForces.F;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MultiplicationTable multiplicationTable =  new MultiplicationTable(n);
        multiplicationTable.multiplication();
    }
}

