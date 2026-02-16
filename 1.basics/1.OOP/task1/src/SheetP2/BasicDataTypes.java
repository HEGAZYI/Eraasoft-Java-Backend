package SheetP2;

import java.util.Scanner;

public class BasicDataTypes {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int i = input.nextInt();
        long l = input.nextLong();
        char c = input.next().charAt(0);
        float f = input.nextFloat();
        double d = input.nextDouble();

        DataPrinter data = new DataPrinter(i, l, c, f, d);
        data.printValues();

        input.close();
    }
}


class DataPrinter {

    private int i;
    private long l;
    private char c;
    private float f;
    private double d;

    public DataPrinter(int i, long l, char c, float f, double d) {
        this.i = i;
        this.l = l;
        this.c = c;
        this.f = f;
        this.d = d;
    }

    public void printValues() {
        System.out.println(i);
        System.out.println(l);
        System.out.println(c);
        System.out.println(f);
        System.out.println(d);
    }
}
