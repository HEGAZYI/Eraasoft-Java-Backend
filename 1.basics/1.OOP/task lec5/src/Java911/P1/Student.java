package Java911.P1;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void printData() {
        System.out.println("Student id : " + this.id);
        System.out.println("Student name : " + this.name);
        System.out.println("Student age : " + this.age);
    }
}
