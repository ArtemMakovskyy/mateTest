package main.SOLID._02_OCP.dao;

import main.SOLID._02_OCP.model.Account;

public interface   AccountDao {
    void add(Account account);
    Account get(String accountNumber);
    void update(Account account);
}
