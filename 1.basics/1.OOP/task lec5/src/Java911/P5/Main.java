package Java911.P5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        String name = sc.next();
        int age = sc.nextInt();
        int number = sc.nextInt();
        String phone = sc.next();

        //Check Person Class
        System.out.println("Person Date:");
        Person person = new Person(id , name);
        person.printPerson();

        //Check Player Class
        System.out.println("Player Date:");
        Player player = new Player(id , name , phone , number);
        player.printPlayer();

        //Check Student Class
        System.out.println("Student Date:");
        Student student = new Student(id , name , phone , age);
        student.printStudent();




    }
}
