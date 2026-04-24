package Java911.P8;

public class API {
    protected int id;
    protected String text;
    protected String imageUrl;

    public API(int id, String text, String imageUrl) {
        this.id = id;
        this.text = text;
        this.imageUrl = imageUrl;
    }

    public void printAPI() {
        System.out.println("API ID: " + id);
        System.out.println("API Text: " + text);
        System.out.println("API Image URL: " + imageUrl);
    }
}
