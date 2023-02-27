package main.java8.streamPractice;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        UniqueNumbers uniqueNumbers = new UniqueNumbers();
        List<Character> uniqueNumbers1 = uniqueNumbers.getUniqueNumbers("987");
        System.out.println(uniqueNumbers1);

    }
    private  static  void a(){
        List<String> list = new ArrayList<>(List.of("Rick", "Jessie", "George", "Garold"));
        list.stream().sorted().limit(3).collect(Collectors.toList());
        list.stream().findFirst().get();
        List<Integer> list1 = new ArrayList<>();

                FilterAndModifyLetters filterAndModifyLetters = new FilterAndModifyLetters();
        String str = filterAndModifyLetters.filterLetters("random");
        System.out.println(str);


        UniqueNumbers uniqueNumbers = new UniqueNumbers();
        uniqueNumbers.getUniqueNumbers("987");

        UppercaseString uppercaseString = new UppercaseString();
        String[] str3 = new String[]{"aaa", "bbbb", "ccccc"};
        System.out.println(uppercaseString.getUppercaseString(new String[]{"abc"}));
    }
}
