package task;

import java.util.ArrayList;
import java.util.List;

public class Language {
    private int id;
    private String name;
    private List<Teacher> teachers = new ArrayList<>();

    public Language() {}

    public Language(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Teacher> getTeachers() { return teachers; }
    public void setTeachers(List<Teacher> teachers) { this.teachers = teachers; }

    // Helper methods
    public void addTeacher(Teacher teacher) {
        if (!teachers.contains(teacher)) {
            teachers.add(teacher);
            teacher.setLanguage(this);
        }
    }

    public void removeTeacher(Teacher teacher) {
        if (teachers.remove(teacher)) {
            teacher.setLanguage(null);
        }
    }

    @Override
    public String toString() {
        return "Language{id=" + id + ", name='" + name + "'}";
    }
}