package CodeForces.V;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PUMGame game = new PUMGame();

        game.printPattern(n);
    }
}

