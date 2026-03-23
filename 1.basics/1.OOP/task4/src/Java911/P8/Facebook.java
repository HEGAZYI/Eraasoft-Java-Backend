package Java911.P8;

public class Facebook extends API{

    public Facebook(int id , String text , String imageUrl) {
        super(id , text , imageUrl);
    }

    public void printFaceBookAPI() {
        System.out.println("You're at FaceBook API NOW!!");
        super.printAPI();
    }
}
