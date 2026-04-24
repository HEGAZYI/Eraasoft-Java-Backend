package Q6;

public class PublicSchool extends Student{

    public PublicSchool(int id, String name) {
        super(id, name);
    }


    public void printPrivateSchoolData() {
        System.out.println("Public School Student:");
        super.printData();
    }
}
