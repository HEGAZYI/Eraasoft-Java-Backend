package CodeForces.Y;

import java.util.Scanner;

public class EasyFibonancci {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();

    int a = 0, b = 1;

    public void fibonancci(){
        for(int i = 1; i <= n; i++) {
            System.out.print(a + " ");

            int next = a + b;
            a = b;
            b = next;
        }
    }


}
