package Java911.P6;

public class PublicSchool extends Student{

    public PublicSchool(int id, String name) {
        super(id, name);
    }


    public void printPublicSchoolData() {
        System.out.println("Public School Student:");
        super.printData();
    }
}
