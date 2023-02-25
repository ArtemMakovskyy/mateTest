package main.SOLID._05_.service;

import main.SOLID._02_OCP.model.Account;
import main.SOLID._02_OCP.service.commission.CommissionHandler;

public interface CommissionStrategy {
    CommissionHandler get(Account.Type type);
}
