package main.SOLID.practice.service;

import main.SOLID.practice.model.OrderTransactions;

import java.math.BigDecimal;
@FunctionalInterface
public interface TransfersRecordCsv {
   void wright(OrderTransactions set);
}
