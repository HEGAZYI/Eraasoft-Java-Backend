import task.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
    // click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    public class Main {
        public static void main(String[] args) {

            // Many-to-Many
            Doctor d1 = new Doctor(1, "Dr. Smith", 120000);
            Patient p1 = new Patient(1, "Alice", 30);
            d1.addPatient(p1);          // also adds doctor to patient

            // One-to-Many
            Language java = new Language(1, "Java");
            Teacher t1 = new Teacher(1, "John", 50000);
            t1.setLanguage(java);       // also adds teacher to language

            // One-to-One
            Employee e1 = new Employee(1, "Bob", 28);
            Phone ph1 = new Phone(1, "555-1234");
            e1.setPhone(ph1);           // also sets employee on phone
    }
}