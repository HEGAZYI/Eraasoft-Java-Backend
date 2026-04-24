package CodeForces.H;

public class OnePrime {
    private int number;
    int checker = 0;

    public OnePrime(int number) {
        this.number = number;
    }

    public void checkPrime() {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                checker++;
            }

        }
        if (checker == 0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
