package main.dependancy_injection.app;

import main.dependancy_injection.lib.Inject;
import main.dependancy_injection.service.BankService;

public class BankOperatorApp {
    @Inject
    private BankService bankService;
    {
        System.out.println("BankOperatorApp constructor");
    }
}
