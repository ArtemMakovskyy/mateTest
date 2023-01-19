package main.clone.lesson.ed;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Human implements Cloneable{
    private String sex, name;
    private int age;
    private Address address;

    @Override
    protected Human clone() {
        try {
            return (Human) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create");
        }
    }
}
