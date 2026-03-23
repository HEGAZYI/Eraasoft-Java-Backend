package Java911.P14;

public class Student {
    String name;
    Email email;

    Student(String name, Email email) {
        this.name = name;
        this.email = email;
    }

    void show() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email.address);
    }
}