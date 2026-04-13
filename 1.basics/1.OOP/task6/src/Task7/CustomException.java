package Task7;

public class CustomException {
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older!");
        }
        System.out.println("Valid age!");
    }
}
