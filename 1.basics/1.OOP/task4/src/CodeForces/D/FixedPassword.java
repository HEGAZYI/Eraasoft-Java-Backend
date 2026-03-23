package CodeForces.D;

import java.util.Scanner;

public
class FixedPassword{
    Scanner sc = new Scanner(System.in);


    public void checkPassword(){
        while (true) {
            int n =  sc.nextInt();
            if (n == 1999){
                System.out.println("Correct");
                break;
            }else{
                System.out.println("Wrong");
            }
        }
    }


}
