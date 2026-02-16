package SheetP1;
import java.util.Scanner;

public class SayHello {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        Hello hello = new Hello(name);
        System.out.println(hello.sayHello());

        scanner.close();
    }
}


class Hello {
    private String name;

    public Hello(String name) {
        this.name = name;
    }

    public String sayHello() {
        return "Hello, " + name;
    }
}
