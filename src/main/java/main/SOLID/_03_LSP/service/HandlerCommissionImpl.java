package main.SOLID._03_LSP.service;

import main.SOLID._03_LSP.model.TypeOperation;
import main.SOLID._03_LSP.service.commission.Commission;
import main.SOLID._03_LSP.service.commission.CommissionBasic;
import main.SOLID._03_LSP.service.commission.CommissionGold;
import main.SOLID._03_LSP.service.commission.CommissionPlatinum;

import java.util.HashMap;
import java.util.Map;

public class HandlerCommissionImpl implements HandlerCommission {
    @Override
    public Commission getCommission(TypeOperation type) {
        return commissionMap().get(type);
    }

    private Map<TypeOperation, Commission> commissionMap() {
        Map<TypeOperation, Commission> commissionMap = new HashMap<>();
        commissionMap.put(TypeOperation.BASIC,new CommissionBasic());
        commissionMap.put(TypeOperation.GOLD,new CommissionGold());
        commissionMap.put(TypeOperation.PREMIUM,new CommissionPlatinum());
        return commissionMap;
    }
}
