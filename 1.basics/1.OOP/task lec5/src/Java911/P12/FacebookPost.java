package Java911.P12;

public class FacebookPost {

    private int id;
    private String text;
    private String image;

    // constructor 1 (id + text)
    public FacebookPost(int id, String text) {
        this.id = id;
        this.text = text;
    }

    // constructor 2 (id + text + image)
    public FacebookPost(int id, String text, String image) {
        this.id = id;
        this.text = text;
        this.image = image;
    }

    public void show() {
        System.out.println("ID: " + id);
        System.out.println("Text: " + text);

        if (image != null) {
            System.out.println("Image: " + image);
        }

        System.out.println("------");
    }
}