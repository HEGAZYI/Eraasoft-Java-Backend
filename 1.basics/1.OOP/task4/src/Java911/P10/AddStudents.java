package Java911.P10;

public class AddStudents implements School {
    @Override
    public void addStudent(String name) {
        System.out.println("You are in Add Student");
        System.out.println("Adding student: "+name);
    }
    @Override
    public void showStudents() {}
}
