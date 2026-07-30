package task;

public class Phone {
    private int id;
    private String phoneNumber;
    private Employee employee;   // one phone → one employee

    public Phone() {}

    public Phone(int id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Employee getEmployee() { return employee; }

    public void setEmployee(Employee employee) {
        // Clear old relationship
        if (this.employee != null) {
            this.employee.setPhone(null);
        }
        this.employee = employee;
        // Set new relationship
        if (employee != null) {
            employee.setPhone(this);
        }
    }

    @Override
    public String toString() {
        return "Phone{id=" + id + ", phoneNumber='" + phoneNumber + "'}";
    }
}