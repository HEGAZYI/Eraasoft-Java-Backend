package Java911.P8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int id = sc.nextInt();
        String text = sc.next();
        String imageUrl = sc.next();

        // Facebook Class
        Facebook fb = new Facebook(id, text, imageUrl);
        fb.printAPI();

        // LinkedIn Class
        LinkedIn ln = new LinkedIn(id, text, imageUrl);
        ln.printAPI();
    }
}
