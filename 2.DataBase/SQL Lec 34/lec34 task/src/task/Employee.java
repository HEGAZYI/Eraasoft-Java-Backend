package task;

public class Employee {
    private int id;
    private String name;
    private int age;
    private Phone phone;   // one employee → one phone

    public Employee() {}

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public Phone getPhone() { return phone; }

    public void setPhone(Phone phone) {
        // Clear old relationship
        if (this.phone != null) {
            this.phone.setEmployee(null);
        }
        this.phone = phone;
        // Set new relationship
        if (phone != null) {
            phone.setEmployee(this);
        }
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', age=" + age + "}";
    }
}