package Task11;

public class NestedTryCatch {
    public static void test() {
        try {
            try {
                int x = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Inner catch handled");
                throw e;
            }
        } catch (ArithmeticException e) {
            System.out.println("Outer catch handled");
        }
    }
}
