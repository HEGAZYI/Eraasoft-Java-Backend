package Task9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThrowsKeyword {
    public static void readFile() throws IOException {
        FileReader file = new FileReader("test.txt");
        BufferedReader br = new BufferedReader(file);

        System.out.println(br.readLine());
    }
}
