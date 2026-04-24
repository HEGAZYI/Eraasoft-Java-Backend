import Q2.q1.Player;
import Q2.q2.Teacher;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Player Class
        /*
        String name = sc.nextLine();
        int number = sc.nextInt();
        Player p2 = new Player(number, name);
        p2.printPlayer();
         */

        //Teacher Class
        long id  = sc.nextInt();
        String name = sc.next();
        int age = sc.nextInt();
        String phoneNumber = sc.next();
        float salary = sc.nextFloat();
        Teacher t = new Teacher(id , name , age , phoneNumber , salary);
        t.printTeacher();


    }

}