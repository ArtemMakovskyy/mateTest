package main.SOLID._03_LSP.service;

import main.SOLID._03_LSP.dao.AccountOperations;
import main.SOLID._03_LSP.dao.AccountOperationsImpl;
import main.SOLID._03_LSP.model.Account;

import java.math.BigDecimal;

public class FinancialOperationsImpl implements FinancialOperations {
    private AccountOperations accountOperations = new AccountOperationsImpl();


    @Override
    public void putFromCashToCashlessAccount(String id, BigDecimal amount) {
        Account account = accountOperations.get(id);
        account.setAmount(account.getAmount().add(amount));
        accountOperations.update(account);
    }

    @Override
    public void withdrawCashFromCashlessAccount(String id, BigDecimal amount) {
        Account account = accountOperations.get(id);
        account.setAmount(account.getAmount().subtract(amount));
        accountOperations.update(account);
    }

    @Override
    public void getAccount(String id) {
        System.out.println(accountOperations.get(id));
    }

    @Override
    public void showAccounts() {
        accountOperations.showAll();
    }

    @Override
    public boolean transfer(String fromId, String toId, BigDecimal amount) {
        Account accountFrom = accountOperations.get(fromId);
        Account accountTo = accountOperations.get(toId);

        BigDecimal commissionWithStrategy = new HandlerCommissionImpl()
                .getCommission(accountFrom.getTypeOperation())
                .get();


        accountFrom.setAmount(accountFrom.getAmount().subtract(amount).subtract(commissionWithStrategy));
        accountTo.setAmount(accountTo.getAmount().add(amount));
        accountOperations.update(accountFrom);
        accountOperations.update(accountTo);
        return true;
    }

}
