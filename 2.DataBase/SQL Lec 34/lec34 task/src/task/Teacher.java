package task;

public class Teacher {
    private int id;
    private String name;
    private double salary;
    private Language language;   // many teachers → one language

    public Teacher() {}

    public Teacher(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Language getLanguage() { return language; }

    public void setLanguage(Language language) {
        // Remove from old language
        if (this.language != null) {
            this.language.getTeachers().remove(this);
        }
        this.language = language;
        // Add to new language
        if (language != null && !language.getTeachers().contains(this)) {
            language.getTeachers().add(this);
        }
    }

    @Override
    public String toString() {
        return "Teacher{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}