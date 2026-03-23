package Java911.P10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Please choose the class you want to bbe in:
                1.AddStudents Class
                2.ShowStudent Class
                3.Exit""");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter the name of the student you want to be added");
                String name = sc.next();
                AddStudents addStudents = new AddStudents();
                addStudents.addStudent(name);
                break;

            case 2:
                System.out.println("show student class");
                ShowStudent showStudent = new ShowStudent();
                showStudent.showStudents();
                break;

            case 3:
                System.exit(0);
        }

    }
}
