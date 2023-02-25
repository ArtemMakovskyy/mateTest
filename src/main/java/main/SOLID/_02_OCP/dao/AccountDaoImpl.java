package main.SOLID._02_OCP.dao;

import main.SOLID._02_OCP.db.Storage;
import main.SOLID._02_OCP.model.Account;

public class AccountDaoImpl implements AccountDao {
    //TODO: Transfer money between accounts
    @Override
    public void add(Account account) {
        Storage.accounts.add(account);
    }

    @Override
    public Account get(String accountNumber) {
        return Storage.accounts.stream()
                .filter(a -> a.getNumber().equals(accountNumber))
                .findFirst().get();
    }

    @Override
    public void update(Account account) {
        // TODO: find account
        // TODO: remove it
        // TODO: add
        Account accountFromDb = get(account.getNumber());
        Storage.accounts.remove(accountFromDb);
        add(account);
    }
}
