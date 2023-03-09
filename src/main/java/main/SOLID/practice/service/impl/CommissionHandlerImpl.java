package main.SOLID.practice.service.impl;

import main.SOLID.practice.model.Type;
import main.SOLID.practice.service.CommissionHandler;
import main.SOLID.practice.service.CommissionService;
import main.SOLID.practice.service.impl.CommissionServiceBankImpl;
import main.SOLID.practice.service.impl.CommissionServiceBasicImpl;
import main.SOLID.practice.service.impl.CommissionServiceGoldImpl;
import main.SOLID.practice.service.impl.CommissionServicePlatinumImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CommissionHandlerImpl implements CommissionHandler {
    @Override
    public BigDecimal commissionHandler(Type type) {
        return commissionServiceMap().get(type).get();
    }
    private Map<Type, CommissionService>commissionServiceMap(){
        Map<Type,CommissionService>commissionServiceMap = new HashMap<>();
        commissionServiceMap.put(Type.BANK,new CommissionServiceBankImpl());
        commissionServiceMap.put(Type.PLATINUM,new CommissionServicePlatinumImpl());
        commissionServiceMap.put(Type.GOLD,new CommissionServiceGoldImpl());
        commissionServiceMap.put(Type.BASIC,new CommissionServiceBasicImpl());
        return commissionServiceMap;
    }
}
