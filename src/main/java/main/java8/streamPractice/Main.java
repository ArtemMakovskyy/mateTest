package main.java8.streamPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>(List.of("Rick", "Jessie", "George", "Garold"));
//        SortNames sortNames = new SortNames();
//        System.out.println(sortNames.sortNames(list));

//        FilterAndModifyLetters filterAndModifyLetters = new FilterAndModifyLetters();
//        System.out.println(filterAndModifyLetters.filterLetters("random"));

        UniqueNumbers un = new UniqueNumbers();
        un.getUniqueNumbers("987");

        UppercaseString uppercaseString = new UppercaseString();

        uppercaseString.getUppercaseString(new String[]{"aaa", "bbbb", "ccccc"});
    }
}
