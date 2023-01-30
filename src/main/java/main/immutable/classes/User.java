package main.immutable.classes;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Builder
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
        this.address = address.clone();
    }

    public User(String name, String lastname, int age, Address address, List<Language> languages) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.address = address.clone();
        this.languages = new ArrayList<>(languages);
//        this.languages = new ArrayList<>(builder().languages);
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

    public List<Language> getLanguages(List<Language> languages) {
//        return languages;
//        return new ArrayList<>(languages);
        // must do deep copy of collection
        List<Language> listCopy = new ArrayList<>();
        for (Language language : languages){
            listCopy.add(language.clone());
        }
        return listCopy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge() && Objects.equals(getName(), user.getName()) &&
                Objects.equals(getLastname(), user.getLastname()) && Objects.equals(getAddress(),
                user.getAddress()) && Objects.equals(getLanguages(languages), user.getLanguages(languages));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastname(), getAge(), getAddress(), getLanguages(languages));
    }

    @Override
    protected User clone() {
        return new User(name, lastname, age, address.clone(), languages);
    }


}
