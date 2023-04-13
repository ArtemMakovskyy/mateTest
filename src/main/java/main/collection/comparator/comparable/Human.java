package main.collection.comparator.comparable;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.Objects;

@Getter
@Setter
public class Human {
    private String name;
    private String lastName;
    private int age;

    private Human(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public static Human of(String name, String lastName, int age) {
        return new Human(name, lastName, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human that = (Human) o;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, age);
    }

    public static final Comparator<Human> compareByLastNameNameAge = new Comparator<Human>() {
        @Override
        public int compare(Human human1, Human human2) {
            int intLastName = human1.getLastName().compareTo(human2.getLastName());
            int intName = human1.getName().compareTo(human2.getName());
            if (intLastName != 0) return intLastName;
            if (intName != 0) return intName;
            return Integer.compare(human1.getAge(), human2.getAge());
        }
    };
    Comparator<Human> compareByAgeLastNameName = new Comparator<Human>() {
        @Override
        public int compare(Human human1, Human human2) {
            int intAge = Integer.compare(human1.getAge(), human2.getAge());
            int intLastName = human1.getLastName().compareTo(human2.getLastName());
            int intName = human1.getName().compareTo(human2.getName());
            if (intAge != 0) return intAge;
            if (intLastName != 0) return intLastName;
            return intName;
        }
    };

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
