package main.dependancy_injection.service.impl;

import main.SOLID.practice.service.AccountService;
import main.dependancy_injection.lib.Inject;
import main.dependancy_injection.service.AuthenticationManager;
import main.dependancy_injection.service.BankService;

import java.math.BigDecimal;

public class BankServiceImpl implements BankService {
    @Inject
    private AccountService accountService;
    @Inject
    private AuthenticationManager authenticationManager;

    @Override
    public void transfer(String accountFrom, String accountTo, BigDecimal amount) {
        accountService.findByNumber(accountFrom);
        accountService.findByNumber(accountTo);
    }
}
