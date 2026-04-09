package Level4;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        // store Product in Hashset
        HashSet<Product> products = new HashSet<>();
        products.add(new Product("1" , 1000));
        products.add(new Product("2" , 2000));
        products.add(new Product("1" , 3000));
        System.out.println("\nSize of products set:" +products.size());

        /*------------------------------------------------------------------------------*/

        // store Student in HashSet
        HashSet<Student> students = new HashSet<>();
        students.add(new Student(1 , "one@eraasoft.com"));
        students.add(new Student(2 , "two@eraasoft.com"));
        students.add(new Student(1 , "three@eraasoft.com"));

        // CASE 1:: equals() and hashCode() using only id  ==> result : 2
        // CASE 2:: equals() and hashCode() using only email  ==> result: 3
        System.out.println("\nSize of students set:" +students.size());

        /*------------------------------------------------------------------------------*/

        // use Car as key on HashMap
        HashMap<Car , String> cars = new HashMap<>();
        cars.put(new Car(1 , "1" ), "1");
        cars.put(new Car(2 , "2" ), "2");
        cars.put(new Car(1 , "1" ), "1");
        System.out.println("\nSize of cars set:" +cars.size());

    }
}
