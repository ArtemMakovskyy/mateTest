package main.SOLID._05_;

import main.SOLID._02_OCP.dao.AccountDao;
import main.SOLID._02_OCP.dao.AccountDaoImpl;
import main.SOLID._02_OCP.model.Account;
import main.SOLID._02_OCP.service.*;
import main.SOLID._02_OCP.service.commission.*;
import main.SOLID._05_.dao.AccountDaoCsvImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MainOCP {
    public static void main(String[] args) {
        createAccounts();
        readFromFile();


    }
    static void readFromFile(){
        AccountDaoCsvImpl accountDaoCsv = new AccountDaoCsvImpl();
        Account account = accountDaoCsv.get("a5788");
        System.out.println(account.getNumber() + " " + account.getType() + " " + account.getAmount());
    }

    static void createAccounts(){
        AccountService accountService = new AccountServiceImpl(new AccountDaoImpl());
        accountService.createNewAccount("a1233");
        accountService.createNewAccount("a5788");

        Account a1233 = new Account();
        a1233.setAmount(BigDecimal.valueOf(3300));
        a1233.setNumber("a1233");
        a1233.setType(Account.Type.GOLD);

        Account a5788 = new Account();
        a5788.setAmount(BigDecimal.valueOf(3300));
        a5788.setNumber("a5788");
        a5788.setType(Account.Type.REGULAR);

        AccountDao accountDao = new AccountDaoImpl();
        accountDao.update(a1233);
        accountDao.update(a5788);

        Map<Account.Type, CommissionHandler> commissionHandlerMap = new HashMap<>();
        commissionHandlerMap.put(Account.Type.GOLD, new GoldCommissionHandler());
        commissionHandlerMap.put(Account.Type.PLATINUM, new PlatinumCommissionHandler());
        commissionHandlerMap.put(Account.Type.USUAL, new UsualCommissionHandler());
        commissionHandlerMap.put(Account.Type.ULTRA, new UltraCommissionHandler());
        commissionHandlerMap.put(Account.Type.REGULAR, new RegularCommissionHandler());

        CommissionStrategy commissionStrategy = new CommissionStrategyImpl(commissionHandlerMap);
        BankService bankService = new BankServiceImpl(new AccountDaoImpl(), commissionStrategy);

        bankService.transfer("a1233", "a5788", BigDecimal.valueOf(1000));
        bankService.transfer("a5788", "a1233", new BigDecimal(1000));

        System.out.println("account: " + accountDao.get("a1233").getNumber() + ", value: " + accountDao.get("a1233").getAmount());
        System.out.println("account: " + accountDao.get("a5788").getNumber() + ", value: " + accountDao.get("a5788").getAmount());
    }
}
