package CodeForces.N;

import java.util.Scanner;

public class NumbersHistogram{
    Scanner sc = new Scanner(System.in);
    char S =  sc.next().charAt(0);
    int L = sc.nextInt();


    public void histogram(){
        for(int i = 0; i <L; i++){
            int N = sc.nextInt();
            for(int j = 0; j <N; j++){
                System.out.print(S);
            }
            System.out.println();
        }
    }
}