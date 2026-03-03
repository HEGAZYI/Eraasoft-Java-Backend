package K;

public class MaxAndMin {
    private int A , B , C ;

    public MaxAndMin(int A, int B,  int C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public int getMin() {
        int min = A;
        if (B < min) min = B;
        if (C < min) min = C;
        return min;
    }

    public int getMax() {
        int max = A;
        if (B > max) max = B;
        if (C > max) max = C;
        return max;
    }

    public void result(){
        System.out.println(getMin() + " " + getMax());
    }
}
