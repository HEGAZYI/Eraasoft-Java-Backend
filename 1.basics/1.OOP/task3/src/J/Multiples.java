package J;

public class Multiples {
    private int A , B ;

    public Multiples(int A, int B) {
        this.A = A;
        this.B = B;
    }

    public void comparison() {
        if (A % B == 0 || B % A == 0 ) {
            System.out.println("Multiples");
        }
        else {
            System.out.println("No Multiples");
        }
    }
}
