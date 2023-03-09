package main.SOLID.practice.service.impl;

import main.SOLID.practice.service.CommissionService;

import java.math.BigDecimal;

public class CommissionServiceGoldImpl implements CommissionService {
    @Override
    public BigDecimal get() {
        return new BigDecimal(4);
    }
}
