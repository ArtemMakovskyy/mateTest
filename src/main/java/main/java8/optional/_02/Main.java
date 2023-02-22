package main.java8.optional._02;

import java.util.Optional;

public class Main {
    /*  how to create Optional
        of
        empty
        ofNullable
        */
    public static void main(String[] args) {
        Optional<String> of = Optional.of("abc");
        Optional<String> empty = Optional.empty();
        Optional<String> o = Optional.ofNullable(null);

        Optional<String> optionalValue = Optional
                .ofNullable(getElByIndex(new String[]{}, 0));

        System.out.println(of.get());
        System.out.println(empty.get());
        System.out.println(o.get());

    }

    private static String getElByIndex(String[] value, int index) {
        if (index >= value.length || index < 0)
            return null;
        return value[index];
    }

}
