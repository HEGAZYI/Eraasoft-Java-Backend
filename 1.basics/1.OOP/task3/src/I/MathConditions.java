package I;

public class MathConditions {
    private int A , B ;

    public MathConditions(int A, int B) {
        this.A = A;
        this.B = B;
    }

    public void comparison() {
        if (A >= B ) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
