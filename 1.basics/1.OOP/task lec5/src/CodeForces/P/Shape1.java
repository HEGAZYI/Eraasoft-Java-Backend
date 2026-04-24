package CodeForces.P;

public class Shape1 {
    private int n;

    public  Shape1(int n){
        this.n=n;
    }

    public void draw(){
        for(int i=n; i > 0;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
