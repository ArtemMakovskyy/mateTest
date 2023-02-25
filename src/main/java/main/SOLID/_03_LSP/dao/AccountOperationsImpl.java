package main.SOLID._03_LSP.dao;

import main.SOLID._03_LSP.db.AccountStorage;
import main.SOLID._03_LSP.model.Account;

import java.util.Optional;

public class AccountOperationsImpl implements AccountOperations {
    AccountStorage accountStorage = new AccountStorage();

    @Override
    public void createNumber(String number) {
        Optional<Account> first = AccountStorage.storage.stream()
                .filter(c -> c.getNumber() == number).findFirst();
        if (first.isEmpty()) {
            Account account = new Account();
            account.setNumber(number);
            accountStorage.storage.add(account);
        }
    }

    @Override
    public boolean update(Account account) {
        Optional<Account> accountOptional = getAccount(account.getNumber());
        boolean present = accountOptional.isPresent();
        if (present) {
            Account findAccount = accountStorage.storage.stream()
                    .filter(c -> c.getNumber() == account.getNumber())
                    .findFirst().get();
            accountStorage.storage.remove(findAccount);
            accountStorage.storage.add(account);
            return true;
        }else {
            accountStorage.storage.add(account);
            return true;
        }
    }

    @Override
    public void delete(String number) {
        if (getAccount(number).isPresent()) {
            accountStorage.storage.remove(getAccount(number).get());
        }
    }

    @Override
    public Account get(String number) {
        Optional<Account> accountOptional = getAccount(number);
        return accountOptional.orElse(new Account());
    }

    @Override
    public void showAll() {
        for (Account account : accountStorage.storage) {
            System.out.println(account);
        }
    }

    private Optional<Account> getAccount(String number) {
        return accountStorage.storage.stream()
                .filter(c -> c.getNumber() == number).findFirst();
    }
}
