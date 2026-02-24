package Q6;

public class Student {
    protected int id;
    protected String name;

    public Student(int id, String name) {
        setId(id);
        setName(name);
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public void printData() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}
