package main.SOLID._05_.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class Account {
    private String number;
    private BigDecimal amount = new BigDecimal(0);
    private Type type;

    public enum Type{
        REGULAR, GOLD, PLATINUM, USUAL, ULTRA;
    }
}
