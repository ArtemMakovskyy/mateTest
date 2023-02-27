package main.java8.streamPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        FilterAndModifyLetters filterAndModifyLetters = new FilterAndModifyLetters();
        filterAndModifyLetters.filterLetters("random");

//        UniqueNumbers uniqueNumbers = new UniqueNumbers();
//        uniqueNumbers.getUniqueNumbers("987");
//
//        UppercaseString uppercaseString = new UppercaseString();
//        String[] str = new String[]{"aaa", "bbbb", "ccccc"};
//        System.out.println(uppercaseString.getUppercaseString(new String[]{"abc"}));
    }
    private  static  void a(){
        List<String> list = new ArrayList<>(List.of("Rick", "Jessie", "George", "Garold"));
        list.stream().sorted().limit(3).collect(Collectors.toList());
        list.stream().findFirst().get();
        List<Integer> list1 = new ArrayList<>();
    }
}
