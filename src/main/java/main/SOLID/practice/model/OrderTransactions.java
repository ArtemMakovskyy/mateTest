package main.SOLID.practice.model;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@ToString
public class OrderTransactions {
    private String accountFrom;
    private String accountTo;
    private BigDecimal amount;
    private BigDecimal commission;
    private char commissionChar;
}
