package main.jdbc.account.dao.jdbc;

import main.jdbc.account.dao.BankAccountDao;
import main.jdbc.account.lib.Dao;
import main.jdbc.account.model.BankAccount;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Dao
public class BankAccountDaoImpl implements BankAccountDao {
    @Override
    public BankAccount create(BankAccount value) {
        return value;
    }

    @Override
    public Optional<BankAccount> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<BankAccount> getAll() {
        return Collections.emptyList();
    }

    @Override
    public BankAccount update(BankAccount value) {
        return value;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Optional<BankAccount> findByAccountNumber(String accountNumber) {
        return Optional.empty();
    }
}
