package Java911.P15;

public class Student {
    String name;
    Course[] courses = new Course[10];
    int count = 0;

    Student(String name) {
        this.name = name;
    }

    void addCourse(Course c) {
        courses[count++] = c;
    }

    void show() {
        System.out.println("Student: " + name);

        for (int i = 0; i < count; i++) {
            System.out.println("- " + courses[i].name);
        }
    }
}