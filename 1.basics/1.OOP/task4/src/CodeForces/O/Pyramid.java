package CodeForces.O;

public class Pyramid {
    private int n;

    public  Pyramid(int n){
        this.n=n;
    }

    public void draw(){
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
