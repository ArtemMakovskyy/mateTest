package main.clone.practice;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Street implements Cloneable {
    private String street;
    private int house;
    private int apartment;

    @Override
    public Street clone() {
        try {
            return (Street) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("can't clone engine class", e);
        }
    }
}