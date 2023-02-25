package main.SOLID._03_LSP.dao;


import main.SOLID._03_LSP.model.Account;

public interface AccountOperations {
    void createNumber(String number);

    boolean update(Account account);

    void delete(String number);

    Account get(String number);

    void showAll();
}
