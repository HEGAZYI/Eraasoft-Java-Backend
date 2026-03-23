package CodeForces.V;

public class PUMGame {

    public void printPattern(int n) {

        int current = 1;

        for (int i = 0; i < n; i++) {

            System.out.println(
                    current + " " +
                            (current + 1) + " " +
                            (current + 2) + " PUM"
            );

            current += 4;
        }
    }
}