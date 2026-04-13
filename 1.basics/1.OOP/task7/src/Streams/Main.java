package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);

        /*---------------------------------*/

        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);

        /*---------------------------------*/

        List<Student> students = Arrays.asList(
                new Student("Ali", "IT", 85),
                new Student("Mona", "CS", 92),
                new Student("Ahmed", "IT", 60),
                new Student("Sara", "CS", 70),
                new Student("Omar", "IS", 45),
                new Student("Laila", "IS", 78)
        );

        /*---------------------------------*/

        List<Employee> employees = Arrays.asList(
                new Employee("Ali", 30, "HR", 5000),
                new Employee("Mona", 25, "IT", 7000),
                new Employee("Ahmed", 30, "HR", 5500),
                new Employee("Sara", 27, "IT", 7200),
                new Employee("Omar", 40, "Finance", 8000),
                new Employee("Laila", 35, "Finance", 8200)
        );

        /*---------------------------------*/

        List<List<String>> nestedWords = Arrays.asList(
                Arrays.asList("Java", "Stream"),
                Arrays.asList("API", "Lambda"),
                Arrays.asList("FlatMap", "Map")
        );

        /*---------------------------------*/

        // 🔹 Basic Stream Operations

        // 1.Filter even numbers from a list of integers.
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        // 2.Find names starting with a specific letter from a list of strings. start with "A"
        List<String> namesStartingWithA = names.stream()
                .filter(n -> n != null && n.startsWith("A"))
                .toList();

        // 3.Convert all strings to uppercase using stream.
        List<String> upperNames = names.stream()
                .filter(n -> n != null)
                .map(String::toUpperCase)
                .toList();

        // 4.Sort a list of integers in descending order using streams.
        List<Integer> sortedDesc = numbers.stream()
                .sorted((a, b) -> b - a)
                .toList();

        // 5.Remove duplicate elements from a list using distinct().
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();

        /*---------------------------------*/

        // 🔹 Intermediate Stream Tasks

        // 1.Count the number of strings longer than 5 characters.
        long count = names.stream()
                .filter(n -> n != null && n.length() > 5)
                .count();

        // 2.Find the first element in a stream that matches a given condition.
        Optional<String> firstS = names.stream()
                .filter(n -> n != null && n.startsWith("S"))
                .findFirst();

        // 3.Check if any number is divisible by 5 in a list.
        boolean anyDivBy5 = numbers.stream()
                .anyMatch(n -> n % 5 == 0);

        // 4.Collect elements into a Set instead of a List.
        Set<Integer> numberSet = numbers.stream()
                .collect(Collectors.toSet());

        // 5.Skip the first 3 elements and return the rest.
        List<Integer> skipped = numbers.stream()
                .skip(3)
                .toList();

        /*---------------------------------*/

        // 🔹 Numeric Streams & Reductions

        // 1.Calculate the sum of a list of integers using reduce.
        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        // 2.Find the maximum and minimum value in a list.
        Optional<Integer> max = numbers.stream().max(Integer::compare);
        Optional<Integer> min = numbers.stream().min(Integer::compare);

        // 3.Calculate the average of a list of doubles.
        OptionalDouble avg = numbers.stream()
                .mapToInt(Integer::intValue)
                .average();

        // 4.Multiply all integers in a list together using reduce.
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);

        // 5.Count how many numbers are positive in a list.
        long positiveCount = numbers.stream()
                .filter(n -> n > 0)
                .count();

        /*---------------------------------*/

        // 🔹 Collectors & Grouping

        // 1.Group a list of students by their department.
        Map<String, List<Student>> studentsByDept = students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));

        // 2.Partition a list of numbers into even and odd using partitioningBy.
        Map<Boolean, List<Integer>> evenOdd = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        // 3.Create a comma-separated string from a list of strings.
        String joinedNames = names.stream()
                .filter(n -> n != null && !n.isEmpty())
                .collect(Collectors.joining(", "));

        // 4. Group employees by age and count how many per age.
        Map<Integer, Long> empByAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge, Collectors.counting()));

        // 5.Find the average salary per department in a list of employees.
        Map<String, Double> avgSalary = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        /*---------------------------------*/

        // 🔹 Optional, Map, FlatMap

        // 1.Flatten a list of lists into a single list.
        List<String> flatList = nestedWords.stream()
                .flatMap(List::stream)
                .toList();

        // 2.Extract all unique characters from a list of words.
        Set<Character> uniqueChars = flatList.stream()
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toSet());

        // 3.Filter a list of Optionals and collect non-empty values.
        List<String> optionalList = (List<String>) List.of(
                        Optional.of("Ali"),
                        Optional.empty(),
                        Optional.of("Mona")
                ).stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        // 4.Map a list of strings to their lengths.
        List<Integer> lengths = names.stream()
                .filter(n -> n != null)
                .map(String::length)
                .toList();

        // 5.Return a list of uppercased words that start with “A”.
        List<String> upperA = names.stream()
                .filter(n -> n != null && n.startsWith("A"))
                .map(String::toUpperCase)
                .toList();

        /*---------------------------------*/

        // 🔹 Advanced Operations

        // 1.Sort a list of employees by salary then by name.
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .thenComparing(Employee::getName))
                .toList();

        // 1.Find the second highest number in a list.
        Optional<Integer> secondHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        // 3.Find duplicate elements in a list of integers.
        Set<Integer> duplicates = numbers.stream()
                .filter(n -> Collections.frequency(numbers, n) > 1)
                .collect(Collectors.toSet());

        // 4.Remove null or empty strings from a list using stream.
        List<String> cleanNames = names.stream()
                .filter(n -> n != null && !n.isEmpty())
                .toList();

        // 5.Partition students into pass/fail groups based on grade.
        Map<Boolean, List<Student>> passFail = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getGrade() >= 60));


    }
}
