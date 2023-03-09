package main.SOLID.practice.dao.impl;

import main.SOLID.practice.dao.AccountDao;
import main.SOLID.practice.db.AccountStorage;
import main.SOLID.practice.model.Account;

import java.util.List;
import java.util.Optional;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void add(Account account) {
        if (foundAccount(account).isEmpty()) {
            AccountStorage.storageList.add(account);
        }else {
            throw new RuntimeException("This accounr already axist");
        }
    }

    @Override
    public Account get(String id) {
        return AccountStorage.storageList.stream()
                .filter(foundAccount -> foundAccount.getId().equals(id))
                .findFirst().get();
    }

    @Override
    public void update(Account account) {
        Optional<Account> foundAccount = foundAccount(account);
        AccountStorage.storageList.remove(foundAccount.get());
        AccountStorage.storageList.add(account);
    }

    @Override
    public List<Account> showAll() {
        return AccountStorage.storageList;
    }

    private Optional<Account> foundAccount(Account account) {
        return AccountStorage.storageList.stream()
                .filter(foundAccount -> foundAccount.getId().equals(account.getId()))
                .findFirst();
    }
}
