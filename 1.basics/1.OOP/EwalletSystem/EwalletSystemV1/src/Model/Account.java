package Model;

public class Account {

    private double balance;
    private String username;
    private String password;
    private String phoneNumber;
    private float age;

    public Account(){}

    public Account(String username, String password, String phoneNumber, float age) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.balance = .0;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public float getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(float age) {
        this.age = age;
    }


}
