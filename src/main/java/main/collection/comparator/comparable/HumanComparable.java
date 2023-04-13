package main.collection.comparator.comparable;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class HumanComparable implements Comparable<HumanComparable> {
    private String name;
    private String lastName;
    private int age;

    private HumanComparable(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public static HumanComparable of(String name, String lastName, int age) {
        return new HumanComparable(name, lastName, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HumanComparable)) return false;
        HumanComparable that = (HumanComparable) o;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, age);
    }

    @Override
    public String toString() {
        return "HumanComparable{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(HumanComparable human) {
        if (this.name.compareTo(human.getName()) != 0){
            return this.name.compareTo(human.getName());
        }
        if (this.lastName.compareTo(human.getLastName()) != 0){
            return this.lastName.compareTo(human.getLastName());
        }
//        return this.age - human.age;
        return Integer.compare(age, human.age);
    }
}
