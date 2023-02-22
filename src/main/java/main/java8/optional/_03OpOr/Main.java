package main.java8.optional._03OpOr;

import main.java8.stream.classes.p_07.model.User;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        /*
        Optional
        - ifPresent
        - orElse
        - orElseGet
        - orElseThrow
         */
        DataBase dataBase = new DataBase();
        Optional<User> userOptional = dataBase.getById(10L);
        //        - ifPresent 1v
        System.out.println("- ifPresent 1v  ....  ");
        userOptional.ifPresent(System.out::println);
        //        - ifPresent 2v
        System.out.println("- ifPresent 2v  ....  ");
        if (userOptional.isPresent()) {
            System.out.println(userOptional.get());
        }

//        --------------------------------
//        - orElse
        Optional<User> byId11 = dataBase.getById(10L);
        User alice = byId11.orElse(new User("Alice", "123"));
        System.out.println("       orElse      "  + alice);


//        - orElseGet
        Optional<User> optional = dataBase.getById(11L);
        User ivan = optional.orElseGet(() -> new User("Alice", "123"));
        User ivan2 = optional.orElseGet(() -> getDefaultUser());
        System.out.println("       orElseGet   " + ivan2);

//        - orElseThrow
        Optional<User> optional2 = dataBase.getById(10L);
//        optional2.get();
        optional2.orElseThrow(()->new RuntimeException("Can't find USER"));

    }

    private static User getDefaultUser() {
        return new User("Alice", "123");
    }
}
