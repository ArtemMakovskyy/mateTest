package main.java8.stream.tasks.c_01;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer>list = List.of(1,2,3,4,5,6);
        List<String>stringList = List.of("one","two","two","two","two");
//        List<Integer>list = List.of(2);
        StreamApi streamApi = new StreamApi();
        System.out.println(streamApi.getOddNumsSum(list));
        System.out.println(streamApi.get___OddNumsSum3(list));

        System.out.println(streamApi.calculateOccurrences(stringList, "two"));
        System.out.println(streamApi.getFirstElement(stringList).get());
        int[]arr = new int[]{4, 1, 10, 20, 11, 3};
        System.out.println(streamApi.getThreeSmallestNumbers(arr));

        System.out.println(streamApi.findElement(stringList, "two"));
    }
}
