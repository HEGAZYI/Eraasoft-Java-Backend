package CodeForces.B;

public class EvenNumbers {
    private int n;

    public EvenNumbers(int n) {
        if (n ==1) {
            System.out.println(-1);
        }else {
            this.n = n;
        }
    }

    public void printEvenNumbers() {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
