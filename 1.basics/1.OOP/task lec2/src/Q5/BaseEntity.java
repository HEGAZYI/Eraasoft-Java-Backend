package Q5;

public class BaseEntity {

    protected int id;
    protected String name;

    public BaseEntity(int id, String name) {
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
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public void printBase() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}