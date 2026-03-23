package CodeForces.Z;

import java.util.Scanner;

public class ThreeNumbers {


        Scanner input = new Scanner(System.in);

        int K = input.nextInt();
        int S = input.nextInt();

        int count = 0;

        public void numbers(){

            for (int x = 0; x <= K; x++) {
                for (int y = 0; y <= K; y++) {
                    int z = S - x - y;

                    if (z >= 0 && z <= K) {
                        count++;
                    }
                }
            }

            System.out.println(count);

        }



}
