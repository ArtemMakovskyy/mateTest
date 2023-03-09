package main.SOLID.practice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fruit {
    private String name;
    private String sort;
    public Fruit(String name) {
        this.name = name;
    }
}
