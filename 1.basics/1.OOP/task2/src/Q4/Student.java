package Q4;


public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        setId(id);
        setName(name);
        setAge(age);
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Student ID must be > 0");
        }
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Student name cannot be empty");
        }
    }

    public void setAge(int age) {
        if (age > 7 && age < 30) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be > 7 and < 30");
        }
    }

    public void printData() {
        System.out.println("Student Data:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}