package Q5;

public class Student extends ShareData{
    private int age ;

    public Student (int id, String name, String phone,int age){
        super(id , name , phone );
        this.age = age;
    }

    public void setAge(int age) {
        if (age > 7 && age < 30) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be > 7 and < 30");
        }
    }

    public void printStudent() {
        printShareData();
        System.out.println("Age: " + age);
    }
}
