package tasks;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Person spongebob1 = new Person(29, "SpongeBob29");
//        Person spongebob2 = new Person(30, "SpongeBob30");
//        Person spongebob3 = new Person(31, "SpongeBob31");
//        Person spongebob4 = new Person(32, "SpongeBob32");
//        PersonNames personNames = new PersonNames();
//        System.out.println(personNames.getPersonNames(List.of(spongebob1, spongebob2, spongebob3, spongebob4)));

        Converter converter = new Converter();
        System.out.println(converter.toKiloPerLiter(24f));
    }

}
