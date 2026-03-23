package CodeForces.I;

import java.util.Scanner;

public
class Palindrome{
    Scanner sc = new Scanner(System.in);

    public void checkPalindrome(){
        int N =  sc.nextInt();
        int tmp = N;
        int rev = 0 ;

        while(N != 0)
        {
            rev = rev*10+N%10;
            N = N/10;
        }
        System.out.println(rev);
        if(tmp == rev)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}