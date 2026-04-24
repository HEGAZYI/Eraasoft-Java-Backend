package Level3;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // create hashMap, put person as key on it
        HashMap<Person, String> map = new HashMap<>();

        // create objects of person as key
        Person person1 = new Person( 101 , "Ahmed");
        Person person2 = new Person( 102 , "Mahmoud");

        // insert < key,value> in map
        map.put( person1, "Employee");
        map.put( person2, "Manager");

        // show map values based on keys
        System.out.println(map.get(person1));
        System.out.println(map.get(person2));

        //Insert another key with same id of pearson1
        Person person3 = new Person( 101, "Mohamed");

        //Check if value is replaced or duplicated
        // value is Employee like person1, because hasCode handled the overridden keys based on id
        // if there is no override on hashcode, the result will be null
        System.out.println(map.get(person3));

        // change value on one of them
        map.put( person3, "Manager");
        System.out.println(map.get(person3)); // now person3 is manager
        System.out.println(map.get(person1)); // person1 will be also manager because it has same key of person3 , so any change on one of them will be in the other

        // try to change key of an object
        Person  person4 = new Person( 103, "Ahmed");
        map.put( person4, "Manager");
        System.out.println(map.get(person4)); // answer is manager
        person4.setId(105);
        System.out.println(map.get(person4)); // result is null , because there is mismatch when trying to find the key because u change the key


    }
}
