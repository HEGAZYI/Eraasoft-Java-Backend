package Q6;

public class PrivateSchool extends Student{

    public PrivateSchool(int id, String name) {
        super(id, name);
    }


    public void printPrivateSchoolData() {
        System.out.println("Private School Student:");
        super.printData();
    }
}
