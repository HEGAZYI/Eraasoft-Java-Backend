package H;

public class TwoNumbers {

    private int A;
    private int B;

    public TwoNumbers(int A, int B) {
        this.A = A;
        this.B = B;
    }

    public int getFloor() {
        return A / B;
    }

    public int getCeil() {
        // Ceil for positive numbers:
        return (A + B - 1) / B;
    }

    public int getRound() {
        // Round to nearest integer
        double value = (double) A / B;
        return (int) Math.round(value);
    }
}

