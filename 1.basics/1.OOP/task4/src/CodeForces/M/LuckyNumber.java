package CodeForces.M;

import java.util.Scanner;

public class LuckyNumber{
    Scanner sc = new Scanner(System.in);

    public void luckyNumber(){
        int A =  sc.nextInt();
        int B =  sc.nextInt();
        int flag = 0;

        for (int i = A; i <= B; i++) {
            if(i == 4 || i==7|| i== 44 || i== 47 || i== 74 ||i==77 ||i==444 ||i==447|| i== 474||
                    i== 477 || i==744 ||i==747 ||i==774 ||i==777 ||i==4444 ||i==4447 ||i==4474||
                    i==4477 || i==4744 ||i==4747||i==4774|| i==4777|| i==7444|| i==7447|| i==7474 ||i==7477 ||i==7744||
                    i== 7747 || i==7774 || i==7777){
                System.out.print(i + " ");
                flag = 1;
            }


        }
        if(flag == 0){
            System.out.println("-1");
        }
    }
}