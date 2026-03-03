package N;

public class Char {

    private char ch;

    public Char(char ch) {
        this.ch = ch;
    }

    public void convert() {
        char newChar ;
        if (Character.isLowerCase(ch)) {
            newChar = Character.toUpperCase(ch);
            System.out.println(newChar);
        } else {
            newChar = Character.toLowerCase(ch);
            System.out.println(newChar);
        }
    }
}
