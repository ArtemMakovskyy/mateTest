package main.java8.streamPractice;

import java.util.ArrayList;
import java.util.List;

public class HelloClass {
    public void prn(){
        System.out.println("156");
        List<Integer> integerList = new ArrayList<>(List.of(5,3,5,8,1,5,6,9,5,68,6,5));
        Integer integer = integerList.stream().findFirst().get();
        System.out.println(integer);
    }
}
