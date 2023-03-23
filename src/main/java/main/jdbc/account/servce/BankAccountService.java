package main.jdbc.account.servce;

import main.jdbc.account.lib.Service;
import main.jdbc.account.model.BankAccount;

import java.math.BigDecimal;
@Service
public interface BankAccountService {
    void transfer(String fromAccount, String toAccount, BigDecimal amount);
    BankAccount create(BankAccount bankAccount);
}
