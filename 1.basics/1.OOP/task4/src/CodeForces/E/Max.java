package CodeForces.E;

import java.util.Scanner;

public
class Max{
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    public void getMax(){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int x = sc.nextInt();

            if(x >max){
                max = x;
            }
        }
        System.out.println(max);
    }

}
