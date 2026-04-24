package CodeForces.S;

import java.util.Scanner;

public class SumOfOdd {
    Scanner sc=new Scanner(System.in);
    private int line;
    private int x;
    private int y;


    public void getSum(){
        int sum=0;
        int tmp;
        line=sc.nextInt();
        while (line!=0){
            x=sc.nextInt();
            y=sc.nextInt();
            if(x > y){
                tmp =x;
                x=y;
                y=tmp;
            }
            for(int i= x+1 ;i<y;i++){
                if(i%2 !=0){
                    sum+=i;
                }
            }
            System.out.println(sum);
            sum  = 0;
            line--;
        }


    }
}
