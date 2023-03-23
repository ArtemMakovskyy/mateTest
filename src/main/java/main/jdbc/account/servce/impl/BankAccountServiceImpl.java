package main.jdbc.account.servce.impl;

import main.dependancy_injection.lib.Inject;
import main.jdbc.account.dao.BankAccountDao;
import main.jdbc.account.lib.Service;
import main.jdbc.account.model.BankAccount;
import main.jdbc.account.servce.BankAccountService;

import java.math.BigDecimal;
import java.util.Optional;
@Service
public class BankAccountServiceImpl implements BankAccountService {
    @Inject
    private BankAccountDao bankAccountDao;



    @Override
    public void transfer(String fromAccount, String toAccount, BigDecimal amount) {
        Optional<BankAccount> senderAccount = bankAccountDao.findByAccountNumber(fromAccount);
        Optional<BankAccount> receiverAccount = bankAccountDao.findByAccountNumber(toAccount);
        if (senderAccount.isEmpty() || receiverAccount.isEmpty()){
            throw new RuntimeException("Can/t find account");
        }
        senderAccount.get().setAmount(senderAccount.get().getAmount().subtract(amount));
        receiverAccount.get().setAmount(senderAccount.get().getAmount().add(amount));

        bankAccountDao.update(senderAccount.get());
        bankAccountDao.update(receiverAccount.get());
    }

    @Override
    public BankAccount create(BankAccount bankAccount) {
        return bankAccountDao.create(bankAccount);
    }
}
