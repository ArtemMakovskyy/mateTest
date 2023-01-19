package main.immutable.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class User implements Cloneable {
    private String name, lastname;
    private int age;
    private Address address;
    private List<Language> languages;

    public User(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public User(String name, String lastname, int age, Address address) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public User(String name, String lastname, int age, Address address, List<Language> languages) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.address = address;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address.clone();
    }

    public List<Language> getLanguages() {
        return new ArrayList<>(languages);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge() && Objects.equals(getName(), user.getName()) && Objects.equals(getLastname(), user.getLastname()) && Objects.equals(getAddress(), user.getAddress()) && Objects.equals(getLanguages(), user.getLanguages());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastname(), getAge(), getAddress(), getLanguages());
    }

    @Override
    protected User clone() {
        return new User(name, lastname, age, address, languages);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
