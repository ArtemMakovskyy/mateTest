package main.SOLID._05_.service.commission;

import java.math.BigDecimal;

public interface CommissionHandler {
    BigDecimal getCommission(BigDecimal amount);
}
