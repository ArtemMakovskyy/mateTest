package main.SOLID._03_LSP;

import main.SOLID._03_LSP.dao.AccountOperations;
import main.SOLID._03_LSP.dao.AccountOperationsImpl;
import main.SOLID._03_LSP.model.Account;
import main.SOLID._03_LSP.model.TypeOperation;
import main.SOLID._03_LSP.service.FinancialOperations;
import main.SOLID._03_LSP.service.FinancialOperationsImpl;

import java.math.BigDecimal;

public class MainPractice {
    public static void main(String[] args) {
        createAccountsInDAO(false);
        finansialOperations(true);

    }

    private static void finansialOperations(boolean showAccounts) {
        FinancialOperations financialOperations = new FinancialOperationsImpl();
        financialOperations.putFromCashToCashlessAccount("artem", new BigDecimal(5000));
        financialOperations.putFromCashToCashlessAccount("lena", new BigDecimal(5000));
        financialOperations.putFromCashToCashlessAccount("sasha", new BigDecimal(5000));
        financialOperations.putFromCashToCashlessAccount("polina", new BigDecimal(5000));

        financialOperations.transfer("artem", "lena", new BigDecimal(700));
        if (showAccounts) financialOperations.showAccounts();

    }

    private static void createAccountsInDAO(boolean showAccounts) {
        AccountOperations accountOperations = new AccountOperationsImpl();
        accountOperations.createNumber("artem");
        Account artem = new Account("artem", "Artem", new BigDecimal(1000), TypeOperation.BASIC);
        Account lena = new Account("lena", "Lena", new BigDecimal(1000), TypeOperation.GOLD);
        Account sasha = new Account("sasha", "Sasha", new BigDecimal(1000), TypeOperation.GOLD);
        Account polina = new Account("polina", "Polina", new BigDecimal(1000), TypeOperation.PREMIUM);
        accountOperations.update(artem);
        accountOperations.update(lena);
        accountOperations.update(sasha);
        accountOperations.update(polina);

        if (showAccounts) accountOperations.showAll();

    }
}
