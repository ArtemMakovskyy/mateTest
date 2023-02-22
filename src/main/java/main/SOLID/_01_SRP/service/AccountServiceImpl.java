package main.SOLID._01_SRP.service;

import main.SOLID._01_SRP.dao.AccountDao;
import main.SOLID._01_SRP.dao.AccountDaoImpl;
import main.SOLID._01_SRP.db.Storage;
import main.SOLID._01_SRP.model.Account;

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
