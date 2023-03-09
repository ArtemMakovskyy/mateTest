package main.SOLID.practice;

import main.SOLID.practice.dao.AccountDao;
import main.SOLID.practice.dao.impl.AccountDaoImpl;
import main.SOLID.practice.model.Account;
import main.SOLID.practice.model.Type;
import main.SOLID.practice.service.AccountService;
import main.SOLID.practice.service.CommissionHandler;
import main.SOLID.practice.service.TransfersRecordCsv;
import main.SOLID.practice.service.impl.AccountServiceImpl;
import main.SOLID.practice.service.impl.CommissionHandlerImpl;
import main.SOLID.practice.service.impl.TransfersRecordCsvImpl;

import java.math.BigDecimal;
import java.util.Arrays;
public class MainPractice {
    public static void main(String[] args) {
        accountDao();
        accountService();
        accountService2();
//        enumService();
    }
    private static void  accountService2(){        AccountDao accountDao = new AccountDaoImpl();
        CommissionHandler commissionHandler = new CommissionHandlerImpl();
        TransfersRecordCsv transfersRecordCsv = new TransfersRecordCsvImpl();
        AccountService accountService
                = new AccountServiceImpl(accountDao,commissionHandler,transfersRecordCsv);
        accountService.transaction("artem","lena",new BigDecimal(200));
        accountService.transaction("lena","artem",new BigDecimal(50));
        accountService.transaction("bank","lena",new BigDecimal(200));
        System.out.println("accountService()2");
        System.out.println(accountService.showAll());
    }
    private static void  enumService(){
        Type type = Type.BASIC;
        int ordinal = type.ordinal();
        String name = type.name();

        Type[] types = Type.values();
        Arrays.stream(types).forEach(n -> System.out.println(n.name()));
    }
    private static void  accountService(){
        AccountDao accountDao = new AccountDaoImpl();
        CommissionHandler commissionHandler = new CommissionHandlerImpl();
        TransfersRecordCsv transfersRecordCsv = new TransfersRecordCsvImpl();
        AccountService accountService
                = new AccountServiceImpl(accountDao,commissionHandler,transfersRecordCsv);

        accountService.createNewId("lena");
        accountService.createAccount(new Account("bank","BANK",new BigDecimal(100_000), Type.BANK));
        accountService.transaction("artem","lena",new BigDecimal(150));
        System.out.println("accountService()");
        System.out.println(accountService.showAll());
    }
    private static void  accountDao(){
        AccountDao accountDao = new AccountDaoImpl();
        Account artem = new Account("artem");
        accountDao.add(artem);
        artem.setName("Artem");
        artem.setAmount(new BigDecimal(1000));
        artem.setType(Type.PLATINUM);
        accountDao.update(artem);
    }
}
