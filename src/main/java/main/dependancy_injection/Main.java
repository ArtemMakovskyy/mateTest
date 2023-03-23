package main.dependancy_injection;

import main.dependancy_injection.app.AtmApp;
import main.dependancy_injection.app.ClientApp;
import main.dependancy_injection.lib.Injector;
import main.dependancy_injection.service.BankService;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInjector();
        ClientApp clientApp = (ClientApp) injector.getInstance(ClientApp.class);


//        ClientApp clientApp = new ClientApp();
        clientApp.login("bob","1234");
        clientApp.sendMoney("5678", BigDecimal.valueOf(100));

//        AtmApp atmApp = new AtmApp();
        AtmApp atmApp = (AtmApp) injector.getInstance(AtmApp.class);
        atmApp.login("12345");
        atmApp.sendMoney("5678",BigDecimal.valueOf(200));

        BankService bankService;
    }
}
