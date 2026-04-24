package Java911.P12;

public class Main {
    public static void main(String[] args) {

        FacebookPost p1 = new FacebookPost(1, "Hello World");
        FacebookPost p2 = new FacebookPost(2, "My Photo", "image.png");

        p1.show();
        p2.show();
    }
}
