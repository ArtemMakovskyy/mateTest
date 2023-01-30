package main.collection.set;

import java.util.Objects;

public class UserComparable implements Comparable<UserComparable> {
    private String name;
    private int age;

    public UserComparable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserComparable)) return false;
        UserComparable user = (UserComparable) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(UserComparable user) {
        int namesCompared = name.compareTo(user.name);
        if (namesCompared != 0) {
            return namesCompared;
        }
        return Integer.compare(age, user.age);
    }
}
