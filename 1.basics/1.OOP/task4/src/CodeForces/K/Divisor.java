package CodeForces.K;

import java.util.Scanner;

public
class Divisor{
    Scanner sc = new Scanner(System.in);

    public void getDivisor(){
        int N =  sc.nextInt();

        for (int i = 1; i <= N; i++) {
            if (N%i==0){
                System.out.println(i);
            }

        }
    }
}