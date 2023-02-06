package main.lambda;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerMain {
    public static void main(String[] args) {
        Consumer<String> sout = System.out::println;
        List<String> list = List.of("Bob", "Elice", "John");
//        for (String name : list) sout.accept(name);
        list.forEach(sout);

        list.forEach(System.out::println);
    }

}
