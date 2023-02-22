package main.java8.stream.classes.func_int_Extra.primitives;

import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pred {
    public static void main(String[] args) {
        List<User> users = List.of(new User("Bob"), new User("Ivan"), new User("Sasha"), new User("Lena"), new User("Dasha"), new User("Bill"));
        List<String> names = users.stream().map(User::getName).collect(Collectors.toList());

        ToIntFunction<String> intFunction1 = (s -> s.length());
        ToIntFunction<String> intFunction2 = (s -> s.chars().sum());
        ToIntFunction<String> intFunction3 = (s -> (int) s.chars().count());


        IntStream intStream = names.stream().mapToInt(String::length);
        intStream.mapToObj(String::valueOf).forEach(System.out::println);


    }
}
