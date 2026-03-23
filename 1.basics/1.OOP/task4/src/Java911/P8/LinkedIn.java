package Java911.P8;

public class LinkedIn extends API {

    public LinkedIn(int id , String text , String imageUrl) {
        super(id , text , imageUrl);
    }

    public void printLinkedInAPI() {
        System.out.println("You're at LinkedIn API NOW!!");
        super.printAPI();
    }
}
