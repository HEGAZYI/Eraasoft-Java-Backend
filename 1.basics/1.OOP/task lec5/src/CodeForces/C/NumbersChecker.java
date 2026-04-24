package CodeForces.C;

public class NumbersChecker {
    int even = 0;
    int odd = 0;
    int positive = 0;
    int negative = 0;

    public void processNumber(int num) {

        if (num % 2 == 0) {
            even++;
        } else {
            odd++;
        }

        if (num > 0) {
            positive++;
        } else if (num < 0) {
            negative++;
        }
    }

    public void printResult() {
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        System.out.println("Positive: " + positive);
        System.out.println("Negative: " + negative);
    }
}
