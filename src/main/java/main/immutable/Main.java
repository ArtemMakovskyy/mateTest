package main.immutable;

import main.immutable.classes.Address;
import main.immutable.classes.Language;
import main.immutable.classes.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        start();
    }

    static void start() {
        Map<User, List<String>> userFavoriteSubject = new HashMap<>();
        List<Language> languages = new ArrayList<>(List.of(
                new Language("English"),
                new Language("Ukrainian")));
        Address address = new Address("Shevchenka", 25);
        User bob = new User("Bob", "Allison", 23, address, languages);

        userFavoriteSubject.put(bob, List.of("Math", "Chemistry"));

        System.out.println(userFavoriteSubject.get(bob));
       bob.getLanguages().add(new Language("Ital"));
        System.out.println(userFavoriteSubject.get(bob));
    }
}
