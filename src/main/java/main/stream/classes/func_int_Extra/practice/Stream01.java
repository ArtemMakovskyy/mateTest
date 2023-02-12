package main.stream.classes.func_int_Extra.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Stream01 {
    static String infLink = "https://howtodoinjava.com/java/stream/java-streams-by-examples/";
    static String string1 = "sadfasd;aasdfasd;asdf;dsaf;df;asdf;5132";
    static List<String> memberNames=List.of("Artem","Elena","Petya");
    public static void main(String[] args) {
        System.err.println("link info: " + infLink);
//        sep();
//        match();
        reduce();
    }

    static void reduce(){
        Optional<String> reduced = memberNames.stream()
                .reduce((s1,s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
    }

    static void match(){
        List<String> memberNames=List.of("Artem","Elena");
        boolean matchedResult = memberNames.stream()
                .anyMatch((s) -> s.startsWith("A"));

        System.out.println(matchedResult);     //true

        matchedResult = memberNames.stream()
                .allMatch((s) -> s.startsWith("A"));

        System.out.println(matchedResult);     //false

        matchedResult = memberNames.stream()
                .noneMatch((s) -> s.startsWith("A"));

        System.out.println(matchedResult);     //false
    }
    static void sep(){
        Stream<String> stream = Stream.of("sadfasd;aasdfasd;asdf;dsaf;df;asdf;5132".split(";"));
        stream.forEach(System.out::println);

        Arrays.stream(string1.split(";")).forEach(System.out::println);

    }
}
