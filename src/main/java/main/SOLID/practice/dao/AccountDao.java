package main.SOLID.practice.dao;

import main.SOLID.practice.model.Account;
import main.collection.pecs.A;

import java.util.List;

public interface AccountDao {
    void add(Account account);
    Account get(String id);
    void update(Account account);
    List<Account>showAll();
}
