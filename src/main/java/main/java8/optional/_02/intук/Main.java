package main.java8.optional._02.intук;

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(5));

        BinaryOperator<Integer> multiply = (x, y) -> x * y;
        System.out.println(multiply.apply(2, 5));

        UnaryOperator<Integer> unaryOperator = (x) -> x * x;
        System.out.println(unaryOperator.apply(5));

        Consumer<Integer> integerConsumer = x -> System.out.println(x);
        integerConsumer.accept(256);

        Supplier<Integer> integerSupplier = () -> (25);
        integerConsumer.accept(2);
        System.out.println(integerSupplier.get());
    }
}
