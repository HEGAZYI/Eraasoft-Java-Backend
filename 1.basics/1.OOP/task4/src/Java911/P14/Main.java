package Java911.P14;

public class Main {
    public static void main(String[] args) {

        Email e = new Email("ahmed@gmail.com");
        Student s = new Student("Ahmed", e);

        s.show();
    }
}