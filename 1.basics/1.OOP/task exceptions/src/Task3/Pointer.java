package Task3;

import java.util.Scanner;

public class Pointer {
    public static void printUpper(String str) {
        try {
            System.out.println(str.toUpperCase());
        } catch (NullPointerException e) {
            System.out.println("Error: String is null!");
        }
    }
}
