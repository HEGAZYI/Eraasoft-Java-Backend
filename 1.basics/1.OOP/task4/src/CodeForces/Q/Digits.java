package CodeForces.Q;

public class Digits {
    public void printDigits(String num) {

        for (int i = num.length() - 1; i >= 0; i--) {
            System.out.print(num.charAt(i) + " ");
        }

        System.out.println();
    }
}
