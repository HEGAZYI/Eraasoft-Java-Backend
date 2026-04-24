package Java911.P2;

import Java911.P2.A.Player;
import Java911.P2.B.Teacher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Check Player Class
        int number = sc.nextInt();
        String  name = sc.next();
        Player player = new Player(number, name);
        player.printPlayer();


        //Check Teacher Class
        long id = sc.nextLong();
        String name1 = sc.next();
        float age = sc.nextFloat();
        String phoneNumber = sc.next();
        float salary = sc.nextFloat();
        Teacher  teacher = new Teacher(id, name1, age, phoneNumber, salary);
        teacher.printTeacher();

    }
}
