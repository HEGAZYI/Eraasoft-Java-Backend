package M;

public class CapOrSmallOrDigit {

    private char ch;

    public CapOrSmallOrDigit(char ch) {
        this.ch = ch;
    }

    public boolean isDigit() {
        return Character.isDigit(ch);
    }

    public boolean isUppercase() {
        return Character.isUpperCase(ch);
    }

    public boolean isLowercase() {
        return Character.isLowerCase(ch);
    }

    public void result(){
        boolean r1 = isDigit();
        boolean r2 = isUppercase();
        boolean r3 = isLowercase();
        if (r1) {
            System.out.println("IS DIGIT");
        } else {
            System.out.println("ALPHA");
            if (r2) {
                System.out.println("IS CAPITAL");
            } else if (r3) {
                System.out.println("IS SMALL");
            }
        }
    }
}
