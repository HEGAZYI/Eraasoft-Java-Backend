package Q3;

public class Sum {
    private int num1;
    private int num2;
    private int num3;

    public Sum(int num1, int num2, int num3) {
       setNum1(num1);
       setNum2(num2);
       setNum3(num3);
    }

    public void setNum1(int num1) {
        validateEven(num1);
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        validateEven(num2);
        this.num2 = num2;
    }
    public void setNum3(int num3) {
        validateEven(num3);
        this.num3 = num3;
    }


    private void validateEven(int number) {
        if (number % 2 != 0) {
            throw new IllegalArgumentException("All numbers must be even!");
        }
    }

    public int calculateSum() {
        return num1 + num2 + num3;
    }

}
