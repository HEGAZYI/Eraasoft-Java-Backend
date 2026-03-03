package O;

public class Calculator {
    private int a;
    private int b;
    private char operator;

    public Calculator(String expr) {

        int pos = -1;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                pos = i;
                operator = c;
                break;
            }
        }

        a = Integer.parseInt(expr.substring(0, pos));
        b = Integer.parseInt(expr.substring(pos + 1));
    }

    public int compute() {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;  // integer division
            default -> 0;
        };
    }
}
