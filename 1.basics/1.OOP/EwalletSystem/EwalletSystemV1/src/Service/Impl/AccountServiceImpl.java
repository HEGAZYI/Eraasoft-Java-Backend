package Service.Impl;

import Model.Account;
import Model.EwalletSystem;
import Service.AccountService;


public class AccountServiceImpl implements AccountService {

    private EwalletSystem  ewalletSystem = new EwalletSystem();


    @Override
    public boolean createAccount(Account account) {

        if (account == null || account.getUsername() == null) {
            throw new IllegalArgumentException("Account and username cannot be null");
        }

        return ewalletSystem.registerAccount(account);
    }

    @Override
    public boolean isAccountExistByUserNameAndPassword(Account account) {

        if (account == null || account.getUsername() == null || account.getPassword() == null) {
            return false;
        }

        // check if there is any account matches both username & password
        return ewalletSystem.validateCredentials(account.getUsername(), account.getPassword());

    }
}