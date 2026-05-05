package Service;

import Model.Account;

import java.util.Map;

public interface Validation {

    public String validateUsername(String username);

    public String validatePassword(String password);

    public String validateAge(int age);

    public String validatePhone(String phone);
}
