package G;

public class Summation {

    private int number;

    public Summation(int number) {
        this.number = number;
    }

    public void sum(){
        int result = (number * (number + 1))/2;
        System.out.println(result);
    }
}
