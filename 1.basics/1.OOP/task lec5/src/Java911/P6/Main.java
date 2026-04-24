package Java911.P6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int id = sc.nextInt();
        String name = sc.next();

        //Private School Class
        PrivateSchool privateSchool = new PrivateSchool(id , name);
        privateSchool.printPrivateSchoolData();

        //Public School Data
        PublicSchool publicSchool = new PublicSchool(id , name);
        publicSchool.printPublicSchoolData();
    }
}
