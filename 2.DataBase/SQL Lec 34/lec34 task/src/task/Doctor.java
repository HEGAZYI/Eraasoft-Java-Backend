package task;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private int id;
    private String name;
    private double salary;
    private List<Patient> patients = new ArrayList<>();

    public Doctor() {}

    public Doctor(int id, String name, double salary) {
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

    public List<Patient> getPatients() { return patients; }
    public void setPatients(List<Patient> patients) { this.patients = patients; }

    // Helper methods to keep bidirectional relationship consistent
    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.getDoctors().add(this);
        }
    }

    public void removePatient(Patient patient) {
        if (patients.remove(patient)) {
            patient.getDoctors().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Doctor{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}