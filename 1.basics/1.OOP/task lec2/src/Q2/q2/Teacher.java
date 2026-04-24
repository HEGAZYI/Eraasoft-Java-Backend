package Q2.q2;

public class Teacher {
    private Long id; // id > 0
    private String name; // size >=3 and all digits char(a-z)
    private float age; // age >= 25 and age <= 60
    private String phoneNumber; //  +20111390660 13 cher and start with +20
    private float salary;  // salary >= 3000

    public  Teacher(Long id, String name, float age, String phoneNumber, float salary) {
        setId(id);
        setName(name);
        setAge(age);
        setPhoneNumber(phoneNumber);
        setSalary(salary);
    }

    public void setId(Long id) {
        if (id != null && id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("id must be greater than 0");
        }
    }

    public void setName(String name) {
        if (name != null && name.length() >=3 && name.matches("[A-Za-z]+")) {
            this.name = name;
        }else {
            throw new IllegalArgumentException("name must be at least 3 letters and contain only characters a to z");
        }
    }

    public void setAge(float age) {
        if (age >= 25 && age <= 60) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("age must be between 25 and 60");
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.length() ==13 && phoneNumber.startsWith("+20")) {
            this.phoneNumber = phoneNumber;
        }else {
            throw new IllegalArgumentException("phone number must start with +20 and be 13 characters");
        }
    }

    public void setSalary(float salary) {
        if (salary >=3000){
            this.salary = salary;
        }else {
            throw new IllegalArgumentException("salary must be at least 3000");
        }
    }

    //print data
    public void printTeacher() {
        System.out.println("Teacher id: " + id);
        System.out.println("Teacher name: " + name);
        System.out.println("Teacher age: " + age);
        System.out.println("Teacher phone: " + phoneNumber);
        System.out.println("Teacher salary: " + salary);
    }
}
