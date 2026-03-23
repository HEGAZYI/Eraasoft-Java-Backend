package CodeForces.H;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        OnePrime onePrime = new OnePrime(number);
        onePrime.checkPrime();
    }
}

