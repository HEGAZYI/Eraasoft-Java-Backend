package Java911.P15;

public class Main {
    public static void main(String[] args) {

        Course c1 = new Course("Java");
        Course c2 = new Course("Python");

        Student s1 = new Student("Ahmed");
        Student s2 = new Student("Hegazy");

        s1.addCourse(c1);
        s1.addCourse(c2);

        s2.addCourse(c1);

        s1.show();
        System.out.println("------");
        s2.show();
    }
}