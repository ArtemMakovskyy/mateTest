package main.java8.optional.optPractice;

import main.java8.stream.classes.p_07.model.User;

import java.util.Optional;

public class OptionPractice {
    public static void main(String[] args) {
//        test1();
        test2();

    }

    static void test2() {
        int id = 1;
        System.out.println(doOptional(id).get());
        if (doOptional(id).isEmpty()){
            System.out.println("");
        }

    }

    static void test1() {
        Optional<User> userOptional = Optional
                .of(new User("Ivan", "123"));

        User user = userOptional.get();
        boolean empty = userOptional.isEmpty();
        System.out.println(empty);
        boolean present = userOptional.isPresent();
        System.out.println(present);


        Optional<User> empty1 = Optional.empty();
        System.out.println(empty1.isEmpty());
        System.out.println(empty1.isPresent());

        Optional<User> userOptional1 = Optional.of(new User(null, null));
        System.out.println(userOptional1.isEmpty());
        System.out.println(userOptional1.isPresent());
    }

    static Optional doOptional(int id) {
        if (id > 0) {
            return Optional.empty();
        }
        return Optional.of("Hello");
    }
}
