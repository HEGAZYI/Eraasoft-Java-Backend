package CodeForces.X;

import java.util.Scanner;

public class ConvertToDecimal {
    Scanner sc = new Scanner(System.in);

    int n =  sc.nextInt();


    public void convert() {


        while (n-- > 0) {
            long n = sc.nextLong();
            int count = 0;

            while (n > 0) {
                if ((n & 1) == 1) {
                    count++;
                }
                n = n >> 1;
            }

            long result = (1L << count) - 1;

            System.out.println(result);
        }
    }
}