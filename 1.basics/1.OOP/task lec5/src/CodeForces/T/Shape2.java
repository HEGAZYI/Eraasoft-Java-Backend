package CodeForces.T;

public class Shape2 {
    private int n;
    public Shape2(int n) {
        this.n = n;
    }

    public void shape(){
        for (int i=1; i<=n; i++) {

            for (int j = n; j > i; j--)
                System.out.print(" ");

            for (int k = 0; k < i * 2 - 1; k++)
                System.out.print("*");

            System.out.println();
        }
    }
}
