package main.clone.lesson.ed;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class Human implements Cloneable{
    private String sex, name;
    private int age;
    private Address address;

    public Human(String sex, String name, int age, Address address) {
        this.sex = sex;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    protected Human clone() {
        try {
            return (Human) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create");
        }
    }
}
