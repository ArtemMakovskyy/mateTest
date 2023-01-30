package main.immutable.practice;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public final class User implements Cloneable {
    private String name;
    private int age;
    private Address address;
    private List<Languages> languagesList;

    public User(String name, int age, Address address, List<Languages> languagesList) {
        this.name = name;
        this.age = age;
        this.address = address.clone();
        this.languagesList = new ArrayList<>(languagesList);
    }

    public List<Languages> getLanguagesCopyCollection(List<Languages>languages) {
        List<Languages> languagesListTemp = new ArrayList<>();
        for (Languages languagesThis : languages){
            languagesListTemp.add(languagesThis.clone());
        }
        return languagesListTemp;
    }

    @Override
    protected User clone() {
        return new User(name, age, address.clone(), getLanguagesCopyCollection(languagesList));
    }
}
