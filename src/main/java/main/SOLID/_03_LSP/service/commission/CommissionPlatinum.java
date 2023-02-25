package main.SOLID._03_LSP.service.commission;

import java.math.BigDecimal;

public class CommissionPlatinum implements Commission {
    @Override
    public BigDecimal get() {
        return new BigDecimal(2);
    }
}
