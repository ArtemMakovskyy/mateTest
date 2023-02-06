package main.lambda;

import java.util.function.Function;

public class Exc {
    public static void main(String[] args) {
        Function<String,String> stringStringFunction = new Function<String, String>() {
            @Override
            public String apply(String s) {
                if (s==null)throw new RuntimeException();
                return s.toUpperCase();
            }
        };
    }
}
