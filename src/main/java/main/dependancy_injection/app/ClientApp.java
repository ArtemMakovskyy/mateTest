package main.dependancy_injection.app;

import lombok.*;
import main.SOLID.practice.service.AccountService;
import main.dependancy_injection.lib.Inject;
import main.dependancy_injection.model.Account;
import main.dependancy_injection.model.User;
import main.dependancy_injection.service.BankService;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ClientApp {
    {
        System.out.println("ClientApp");
    }

    @Inject
    private Account account;
    @Inject
    private BankService bankService;
    @Inject
    private AccountService accountService;
    private User currentUser;

    public void login(String login, String password) {

    }

    public void sendMoney(String to, BigDecimal amount) {
    }
}
