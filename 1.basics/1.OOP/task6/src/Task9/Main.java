package Task9;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            ThrowsKeyword.readFile();
        } catch (IOException e) {
            System.out.println("IO Exception occurred!");
        }
    }
}
