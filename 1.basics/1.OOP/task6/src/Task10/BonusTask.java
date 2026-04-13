package Task10;

public class BonusTask {
    public  void test() {
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught exception");
        } finally {
            System.out.println("Finally always executes!");
        }
    }
}
