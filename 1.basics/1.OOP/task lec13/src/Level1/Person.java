package Level1;

import java.util.Objects;

public class Person {

    // Define Fields
    private int id;
    private String name;


    // Define Constructor
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }


    //Define Getters && Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // Define equals() using id & name
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
