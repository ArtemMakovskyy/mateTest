package main.SOLID._02_OCP.service;

import main.SOLID._02_OCP.dao.AccountDao;
import main.SOLID._02_OCP.model.Account;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao ;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void createNewAccount(String accountNumber) {
        Account account = new Account();
        account.setNumber(accountNumber);
        accountDao.add(account);
    }
}
