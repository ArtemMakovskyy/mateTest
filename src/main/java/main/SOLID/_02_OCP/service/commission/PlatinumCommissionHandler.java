package main.SOLID._02_OCP.service.commission;

import java.math.BigDecimal;

public class PlatinumCommissionHandler implements CommissionHandler{

    @Override
    public BigDecimal getCommission(BigDecimal amount) {
        return new BigDecimal(0);
    }
}
