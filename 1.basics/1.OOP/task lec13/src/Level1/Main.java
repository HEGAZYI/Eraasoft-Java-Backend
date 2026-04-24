package Level1;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        // First:: Create object from Pearson Class
        Person person1 = new Person(1 , "Ahmed");
        Person person2 = new Person(1 , "Ahmed");

        //Check equals before making our equals()
        System.out.println("Compare two objects behavior before overriding equals()");
        System.out.println(person1.equals(person2)); // false , because we used equals() that compare objects by reference from Object class. [it will be true after override equals()]
        System.out.println(person1 ==  person2); // false, because two objects have different addresses
        System.out.println(person1.getId() == person2.getId()); // true, because the two objects have same id

        // --> SO!! Before using override equals function the objects used equals() from Object class that compare objects by reference


        //Check Behavior after override of equals()
        System.out.println("\nCompare two objects behavior after overriding equals()");
        System.out.println(person1.equals(person2)); // true , now we used override equals()


        //What happens if you override equals() but NOT hashCode()?
        /*
            Answer:: if u made set of class objects it will count each object as different one
            if u have 2 objects the set will count 2
            but if u used overridden hashCode the set size will be 1
        */

        //Check Using HashSet
        System.out.println("\nCheck HashSet...");
        HashSet<Person> set = new HashSet<>();
        set.add(person1);
        set.add(person2);
        System.out.println(set.size()); // 1 , because of overridden hashCode , without it the size will be 2



    }
}
