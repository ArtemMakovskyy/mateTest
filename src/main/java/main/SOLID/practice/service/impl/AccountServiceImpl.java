package main.SOLID.practice.service.impl;

import main.SOLID.practice.dao.AccountDao;
import main.SOLID.practice.model.Account;
import main.SOLID.practice.model.OrderTransactions;
import main.SOLID.practice.service.AccountService;
import main.SOLID.practice.service.CommissionHandler;
import main.SOLID.practice.service.TransfersRecordCsv;

import java.math.BigDecimal;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    private CommissionHandler commissionHandler;
    private TransfersRecordCsv transfersRecordCsv;

    public AccountServiceImpl(AccountDao accountDao,
                              CommissionHandler commissionHandler,
                              TransfersRecordCsv transfersRecordCsv) {
        this.accountDao = accountDao;
        this.commissionHandler = commissionHandler;
        this.transfersRecordCsv = transfersRecordCsv;
    }

    @Override
    public void createNewId(String id) {
        accountDao.add(new Account(id));
    }

    @Override
    public void createAccount(Account account) {
        accountDao.add(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.update(account);
    }

    @Override
    public List<Account> showAll() {
        return accountDao.showAll();
    }

    @Override
    public void transaction(String idFrom, String idTo, BigDecimal amount) {
        Account accountFrom = accountDao.get(idFrom);
        Account accountTo = accountDao.get(idTo);

        BigDecimal commission
                = new CommissionHandlerImpl().commissionHandler(accountFrom.getType());

        accountFrom.setAmount(accountFrom.getAmount().subtract(amount).subtract(commission));
        accountDao.update(accountFrom);
        accountTo.setAmount(accountFrom.getAmount().add(amount));
        accountDao.update(accountTo);
        Account bank = accountDao.get("bank");
        bank.setAmount(bank.getAmount().add(commission));
        accountDao.update(bank);

        transfersRecordCsv.wright(
                new OrderTransactions(
                        accountFrom.getId()
                        ,accountTo.getId()
                        ,amount,commission
                        ,accountFrom.getType().getCharType()));

    }

    @Override
    public Account get(String id) {
        return accountDao.get(id);
    }
}
