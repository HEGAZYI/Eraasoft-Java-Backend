package JavaP1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student ID:");
        int id = sc.nextInt();
        System.out.println("Enter Student Name:");
        String name = sc.next();
        System.out.println("Enter Student Age:");
        int age = sc.nextInt();

        Student student = new Student(id , name, age);
        student.showData();


    }
}