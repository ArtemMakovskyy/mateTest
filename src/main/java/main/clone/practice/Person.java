package main.clone.practice;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private String name;
    private String serName;
    private int age;
    private Sex sex;
    private Street street;

//    @Override
//    public Person clone() {
//       return new Person(name, serName, age, sex, street.clone());
//    }
    @Override
    public Person clone() {
        try {
            Person clonePerson = (Person) super.clone();
            return clonePerson;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && Objects.equals(getName(), person.getName()) && Objects.equals(getSerName(), person.getSerName()) && getSex() == person.getSex() && Objects.equals(getStreet(), person.getStreet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSerName(), getAge(), getSex(), getStreet());
    }
}
