package main.dependancy_injection.app;

import main.dependancy_injection.lib.Inject;
import main.dependancy_injection.model.User;
import main.dependancy_injection.service.AccountService;
import main.dependancy_injection.service.BankService;

import java.math.BigDecimal;

public class AtmApp {
    @Inject
  private   BankService bankService;
   private @Inject
    AccountService accountService;
   private User currentUser;
    {
        System.out.println("AtmApp");
    }
    @Inject
    public void sendMoney(String s, BigDecimal valueOf) {
    }

    public void login(String phoneNumber) {
    }
}
