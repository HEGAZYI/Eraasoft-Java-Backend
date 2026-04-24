package Q5;

public class Person extends BaseEntity {

    public Person(int id, String name) {
        super(id, name);
    }

    public void printPerson() {
        printBase();
    }
}