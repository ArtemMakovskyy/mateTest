package main.immutable.finalfields;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User bob = new User("Bob","Ivanov",
                List.of(new Languages("Russian"),new Languages("Ukraine")),
                new Address("Polevaya",25));

        User cloneBob = bob.clone();
        System.out.println(bob);
        System.out.println(cloneBob);
    }
}
