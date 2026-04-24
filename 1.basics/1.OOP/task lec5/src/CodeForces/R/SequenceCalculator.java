package CodeForces.R;

public class SequenceCalculator {

    public void printSequence(int a, int b) {

        int min = Math.min(a, b);
        int max = Math.max(a, b);

        int sum = 0;

        for (int i = min; i <= max; i++) {
            System.out.print(i + " ");
            sum += i;
        }

        System.out.println("sum =" + sum);
    }
}