package main.SOLID._01_SRP.dao;

import main.SOLID._01_SRP.model.Account;

public interface AccountDao {
    void add(Account account);
    Account get(String accountNumber);
    void update(Account account);
}
