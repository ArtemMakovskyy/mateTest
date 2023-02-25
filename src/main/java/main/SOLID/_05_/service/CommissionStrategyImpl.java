package main.SOLID._05_.service;

import main.SOLID._02_OCP.model.Account;
import main.SOLID._02_OCP.service.CommissionStrategy;
import main.SOLID._02_OCP.service.commission.CommissionHandler;

import java.util.Map;

public class CommissionStrategyImpl implements CommissionStrategy {
    private Map<Account.Type, CommissionHandler> commissionHandlerMap;

    public CommissionStrategyImpl(Map<Account.Type, CommissionHandler> commissionHandlerMap) {
        this.commissionHandlerMap = commissionHandlerMap;
    }

    @Override
    public CommissionHandler get(Account.Type type) {
        // would use if-> else but better...
        return commissionHandlerMap.get(type);
    }
}
