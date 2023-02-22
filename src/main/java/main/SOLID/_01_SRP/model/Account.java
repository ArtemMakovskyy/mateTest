package main.SOLID._01_SRP.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class Account {
    private String number;
    private BigDecimal amount = new BigDecimal(0);
}
