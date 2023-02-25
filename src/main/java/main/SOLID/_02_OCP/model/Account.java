package main.SOLID._02_OCP.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class Account {
    private String number;
    private BigDecimal amount = new BigDecimal(0);
    private Type type;

    public enum Type{
        REGULAR, GOLD, PLATINUM, USUAL, ULTRA;
    }
}
