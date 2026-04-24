package Service;

import Model.Account;

public interface AccountService {

    // create new account by the user
    boolean createAccount(Account account);

    // check if the user account exists or not
    boolean isAccountExistByUserNameAndPassword(Account account);


}
