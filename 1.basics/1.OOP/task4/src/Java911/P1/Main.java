package Java911.P1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int id = sc.nextInt();
        String name = sc.next();
        int age = sc.nextInt();

        Student  student = new Student(id, name, age);

        student.printData();
    }
}
