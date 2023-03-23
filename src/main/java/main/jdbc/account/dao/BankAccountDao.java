package main.jdbc.account.dao;

import main.jdbc.account.model.BankAccount;

import java.util.List;
import java.util.Optional;

public interface BankAccountDao {
    BankAccount create(BankAccount value);
    Optional<BankAccount>get(Long id);
    List<BankAccount> getAll();
    BankAccount update(BankAccount value);
    boolean delete(Long id);

    Optional<BankAccount>findByAccountNumber(String accountNumber);
}
