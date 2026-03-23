package CodeForces.F;

public class MultiplicationTable {
    private int number;

    public  MultiplicationTable(int number) {
        if(number > 0) {
            this.number = number;
        }
    }

    public void multiplication() {
        for(int i = 1; i <= 12; i++) {
            System.out.println(number + " * "  + i + " = " + number*i);
        }
    }

}
