package Level2;



import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        //Check behavior before using override on HashSet

        Person person1 = new Person(1 , "ahmed");
        Person person2 = new Person(1 , "ahmed");

        System.out.println("\nCheck behavior before using override on HashSet...");
        HashSet<Person> set = new HashSet<>();
        set.add(person1);
        set.add(person2);
        System.out.println(set.size()); // size 2 because set consider them two different objects
        System.out.println("Here, the answer should be 2 because we doesn't make override on hashSet until now!!\nafter making override it will be 1");

        /*------------------------------------------------------------------------------*/

        // Check behavior after using override on HashSet

        Person person3 = new Person(1 , "ahmed");
        Person person4 = new Person(1 , "mohamed");

        System.out.println("\nCheck behavior after using override on HashSet...");
        HashSet<Person> set2 = new HashSet<>();
        set2.add(person3);
        set2.add(person4);
        System.out.println(set2.size()); // size 1 because set consider them one object by comparing id

        /*------------------------------------------------------------------------------*/

        /*
         Add 10 Person objects where:
        Some have same id
        Some have different id
        Check how many remain in the HashSet
        */
        HashSet<Person> set3 = new HashSet<>();
        set3.add(new Person(1 , "ahmed")); // id:: 1
        set3.add(new Person(2 , "ahmed"));
        set3.add(new Person(1 , "ahmed")); // id:: 1
        set3.add(new Person(3 , "ahmed"));
        set3.add(new Person(1 , "ahmed")); // id:: 1
        set3.add(new Person(4 , "ahmed"));
        set3.add(new Person(1 , "ahmed")); // id:: 1
        set3.add(new Person(4 , "ahmed"));
        set3.add(new Person(1 , "ahmed")); // id:: 1
        set3.add(new Person(5 , "ahmed"));

        // check size of set3
        // fist: based on id the size is 5
        // second: based on name the size is 1
        // last: based on id + name the size is 5
        System.out.println("\nThe size of set3 using hashcode by only id: " + set3.size());

        /*------------------------------------------------------------------------------*/

        /*
        Try changing equality logic:
        First: based on id
        Then: based on name
        Then: based on both
         */

        HashSet<Person> set4 = new HashSet<>();

        //First: based on id
        set4.add(new Person(1 , "ahmed"));
        set4.add(new Person(1 , "mohamed"));
        set4.add(new Person(1 , "ali"));

        //Then: based on name
        set4.add(new Person(2 , "ahmed"));
        set4.add(new Person(3 , "ahmed"));
        set4.add(new Person(4 , "ahmed"));

        //Then: based on both
        set4.add(new Person(5 , "ali"));
        set4.add(new Person(5 , "ali"));
        set4.add(new Person(5 , "ali"));

        // check size of set3
        // fist: based on id the size is 5, because  there are 5 objects with different id
        // second: based on name the size is 3 , because  there are 3 objects with different name
        // Last: based on id + name size is 7 , because  there are 7 objects with different id + name
        System.out.println("\nThe size of set3 using hashcode by only id: " + set4.size());
    }
}
