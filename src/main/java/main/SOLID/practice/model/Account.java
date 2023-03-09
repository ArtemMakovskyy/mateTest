package main.SOLID.practice.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {
    private String id;
    private String name;
    private BigDecimal amount;
    private Type type;

    {
        setType(Type.BASIC);
    }

    public Account(String id) {
        this.id = id;
    }
}
