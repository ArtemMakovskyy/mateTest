package main.SOLID._05_.service;

import main.SOLID._02_OCP.dao.AccountDao;
import main.SOLID._02_OCP.model.Account;
import main.SOLID._02_OCP.service.AccountService;

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
