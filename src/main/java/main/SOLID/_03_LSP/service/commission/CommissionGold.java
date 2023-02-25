package main.SOLID._03_LSP.service.commission;

import java.math.BigDecimal;

public class CommissionGold implements Commission {
    @Override
    public BigDecimal get() {
        return new BigDecimal(5);
    }
}
