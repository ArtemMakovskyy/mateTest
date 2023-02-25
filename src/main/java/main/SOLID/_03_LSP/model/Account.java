package main.SOLID._03_LSP.model;

import lombok.*;

import java.math.BigDecimal;
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String number;
    private String userName;
    private BigDecimal amount;
    private TypeOperation typeOperation;
}
