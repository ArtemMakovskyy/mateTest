package main.SOLID._03_LSP.service;

import java.math.BigDecimal;

public interface FinancialOperations {
    void putFromCashToCashlessAccount(String id, BigDecimal amount);
    void withdrawCashFromCashlessAccount(String id, BigDecimal amount);
    void getAccount(String id);
    void showAccounts();
    boolean transfer(String fromId, String toId, BigDecimal amount);



}
