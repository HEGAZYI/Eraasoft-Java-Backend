package Java911.P4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        String name = sc.next();

        // Check Player Class
        int number = sc.nextInt();
        System.out.println("Player Data:");
        Player player = new Player(id, name, number);
        player.printPlayer();
        System.out.println("---------------------");

        //Check Student Class
        int age = sc.nextInt();
        System.out.println("Student Data:");
        Student student = new Student(id, name, age);
        student.printStudent();

    }
}
