package Task6;

public class CatchBlocks {
    public  void test() {
        try {
            String str = null;
            System.out.println(str.length());

            int x = 10 / 0;
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException");
        }
    }
}
