package main.SOLID.practice.service;

import main.SOLID.practice.model.Account;
import main.collection.pecs.A;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    void createNewId(String id);
    void createAccount(Account account);
    void updateAccount(Account account);
    List<Account>showAll();
    void transaction(String idFrom, String idTo, BigDecimal amount);
    Account get (String id);
}
