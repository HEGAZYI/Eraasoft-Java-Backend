package Java911.P4;

public class Student extends EntityClass{
    private int age;

    public Student(int id, String name, int age){
        super(id, name);
        setAge(age);
    }

    private  void setAge(int age){
        if(age > 7 && age < 30){
            this.age = age;
        }else{
            throw new IllegalArgumentException("age must be between 7 and 30");
        }
    }

    public void printStudent(){
        printBasicData();
        System.out.println("age: " + age);
    }

}
