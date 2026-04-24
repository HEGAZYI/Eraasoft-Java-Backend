package CodeForces.U;

public class SumCalculation {

    public int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }


    public int calculate(int n, int a, int b) {

        int total = 0;

        for (int i = 1; i <= n; i++) {

            int sum = digitSum(i);

            if (sum >= a && sum <= b) {
                total += i;
            }
        }

        return total;
    }
}