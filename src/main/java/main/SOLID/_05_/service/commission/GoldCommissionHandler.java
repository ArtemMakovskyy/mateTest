package main.SOLID._05_.service.commission;

import main.SOLID._02_OCP.service.commission.CommissionHandler;

import java.math.BigDecimal;

public class GoldCommissionHandler implements CommissionHandler {

    @Override
    public BigDecimal getCommission(BigDecimal amount) {
        return new BigDecimal(3);
    }
}
