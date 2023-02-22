package main.SOLID._01_SRP;

import main.SOLID._01_SRP.dao.AccountDao;
import main.SOLID._01_SRP.dao.AccountDaoImpl;
import main.SOLID._01_SRP.model.Account;
import main.SOLID._01_SRP.service.AccountService;
import main.SOLID._01_SRP.service.AccountServiceImpl;
import main.SOLID._01_SRP.service.BankService;
import main.SOLID._01_SRP.service.BankServiceImpl;

import java.math.BigDecimal;

public class Main {
    // TODO: db - database

    public static void main(String[] args) {
        firstOperation();
    }

    private static void firstOperation() {
        AccountService accountService = new AccountServiceImpl(new AccountDaoImpl());
        accountService.createNewAccount("a197");
        accountService.createNewAccount("a123");
        accountService.createNewAccount("a578");

        Account a1979 = new Account();
        a1979.setAmount(BigDecimal.valueOf(300));
        a1979.setNumber("a197");

        Account a123 = new Account();
        a123.setAmount(BigDecimal.valueOf(300));
        a123.setNumber("a123");

        Account a578 = new Account();
        a578.setAmount(BigDecimal.valueOf(300));
        a578.setNumber("a578");

        AccountDao accountDao = new AccountDaoImpl();
        accountDao.update(a1979);
        accountDao.update(a123);
        accountDao.update(a578);


        BankService bankService = new BankServiceImpl(new AccountDaoImpl());
        bankService.transfer("a123", "a578", BigDecimal.valueOf(10));
        bankService.transfer("a197", "a578", BigDecimal.valueOf(20));

        System.out.println("account: " + accountDao.get("a197").getNumber() + ", value: " + accountDao.get("a197").getAmount());
        System.out.println("account: " + accountDao.get("a123").getNumber() + ", value: " + accountDao.get("a123").getAmount());
        System.out.println("account: " + accountDao.get("a578").getNumber() + ", value: " + accountDao.get("a578").getAmount());
    }
}
