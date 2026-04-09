package Level3;

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

    // hashCode based on id

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
