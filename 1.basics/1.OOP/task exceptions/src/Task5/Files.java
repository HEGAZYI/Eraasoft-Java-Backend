package Task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Files {
    public static void readFile() {
        try {
            File file = new File("test.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        }
    }
}
