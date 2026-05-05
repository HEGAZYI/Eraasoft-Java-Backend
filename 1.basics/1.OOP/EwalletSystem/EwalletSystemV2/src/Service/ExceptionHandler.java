package Service;

public class ExceptionHandler {

    public static double safeDoubleInput(String input) {
        try {
            return Double.parseDouble(input);
        } catch (Exception e) {
            System.out.println("❌ Invalid number format!");
            return -1;
        }
    }

    public static int safeIntInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("❌ Invalid integer!");
            return -1;
        }
    }
}