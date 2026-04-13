package Task8;

public class Main {
    public static void main(String[] args) {
        try {
            PropagateException.method2();
        } catch (ArithmeticException e) {
            System.out.println("Exception propagated to main!");
        }
    }
}
