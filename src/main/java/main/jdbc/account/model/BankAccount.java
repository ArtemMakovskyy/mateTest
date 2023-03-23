package main.jdbc.account.model;

import lombok.*;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public
class BankAccount {
    private Long id;
    private BigDecimal amount;
    private String accountNumber;
    private String ownerName;
}
