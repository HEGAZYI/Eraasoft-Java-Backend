package CodeForces.G;

import java.util.Scanner;

public class Factorial{
    Scanner sc = new Scanner(System.in);

    public void getFactorial(){
        long factorial=1;
        int numOfReapeating = sc.nextInt();

        while(numOfReapeating > 0)
        {
            int num = sc.nextInt();

            for(int i=1; i<=num ; i++)
            {
                factorial*=i;
            }
            System.out.println(factorial);;
            factorial =1;
            numOfReapeating--;
        }
    }
}