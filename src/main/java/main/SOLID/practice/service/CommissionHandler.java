package main.SOLID.practice.service;

import main.SOLID.practice.model.Type;

import java.math.BigDecimal;

public interface CommissionHandler {

    BigDecimal commissionHandler(Type type);
}
