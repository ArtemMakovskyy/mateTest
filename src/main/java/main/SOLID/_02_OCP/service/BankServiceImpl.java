package main.SOLID._02_OCP.service;

import main.SOLID._02_OCP.dao.AccountDao;
import main.SOLID._02_OCP.model.Account;
import main.SOLID._02_OCP.service.commission.CommissionHandler;

import java.math.BigDecimal;

public class BankServiceImpl implements BankService {
    private AccountDao accountDao;
    private CommissionStrategy commissionStrategy;

    public BankServiceImpl(AccountDao accountDao, CommissionStrategy commissionStrategy) {
        this.accountDao = accountDao;
        this.commissionStrategy = commissionStrategy;
    }

    @Override
    public void transfer(String fromAccountNumber
            , String toAccountNumber, BigDecimal amount) {
        Account fromAccount = accountDao.get(fromAccountNumber);
        Account toAccount = accountDao.get(toAccountNumber);

        // TODO: Create account Type and calculate it
        // Account.Type.REGULAR -> 1%
        // Account.Type.GOLD -> 3 uah
        // Account.Type.PLATINUM -> 0 uah
        // Account.Type.USUAL -> 10 uah
//        BigDecimal commission = new BigDecimal(0);
//        if (fromAccount.getType() == Account.Type.REGULAR){
//            commission = amount.multiply(new BigDecimal("0.01"));
//        }else if(fromAccount.getType() == Account.Type.GOLD) {
//            commission = new BigDecimal(3);
//        }else if(fromAccount.getType() == Account.Type.USUAL) {
//            commission = new BigDecimal(10);
//        }


        BigDecimal commission = commissionStrategy.get(fromAccount.getType()).getCommission(amount);

        BigDecimal newValueFrom = fromAccount.getAmount().subtract(amount).subtract(commission);
        fromAccount.setAmount(newValueFrom);

        BigDecimal newValueTo = toAccount.getAmount().add(amount);
        toAccount.setAmount(newValueTo);

        accountDao.update(fromAccount);
        accountDao.update(toAccount);
    }

}
