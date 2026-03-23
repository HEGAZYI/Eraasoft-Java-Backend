package Java911.P7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        String name = sc.next();
        int  number = sc.nextInt();
        String fcode = sc.next();
        String rcode = sc.next();

        // clupFc class
        ClubFc clubFc = new ClubFc(id , name , number , fcode);
        clubFc.printWithCode();

        //clupRc class
        ClubRc clubRc = new ClubRc(id , name , number , rcode);
        clubRc.printWithCode();
    }
}
