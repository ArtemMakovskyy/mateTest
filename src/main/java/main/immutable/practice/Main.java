package main.immutable.practice;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User bob = new User("Bob",23,
                new Address("Kyiv","Poleva",25),
                List.of(new Languages("Ukrainian"),new Languages("Russian")));
        User anna = new User("Anna",24,
                new Address("Borova","Zaliznichna",16),
                List.of(new Languages("Ukrainian"),new Languages("Russian"),new Languages("English")));
        System.out.println(bob);
        System.out.println(anna);
        User bobCopy = bob.clone();
        User annaCopy = anna.clone();


    }
}
