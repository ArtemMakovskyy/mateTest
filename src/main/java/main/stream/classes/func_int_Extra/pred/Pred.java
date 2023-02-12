package main.stream.classes.func_int_Extra.pred;

import java.util.List;
import java.util.function.Function;

public class Pred {
    public static void main(String[] args) {
        List<User> users = List.of(new User("Bob"), new User("Ivan"), new User("Sasha"), new User("Lena"), new User("Dasha"), new User("Bill"));

//        Predicate<User> userPredicate = new Predicate<User>() {
//            @Override
//            public boolean test(User user) {
//                return user.getName().startsWith("B");
//            }
//        };
//        System.out.println(userPredicate.test(users.get(0)));
//
//        Predicate<User> userPredicate2 = user -> user.getName().startsWith("B");
//        for (User user : users) {
//            if (userPredicate2.test(user)) System.out.println(user);
//        }

        users.stream().filter(u -> u.getName().startsWith("B")).forEach(x -> System.out.println(x));
        System.out.println();
        users.forEach(System.out::println);

        Function <User,Integer>integerFunction = (f)-> f.getName().length();
        users.stream().map((f)-> f.getName().length()).forEach(System.out::println);


    }
}
