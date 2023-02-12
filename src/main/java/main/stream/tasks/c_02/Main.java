package main.stream.tasks.c_02;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        String link = "https://highload.today/java-stream-api/";
//        String link2 =" https://www.youtube.com/watch?v=HNK3DJkWNFY";
//        String HashMap =" https://annimon.com/article/2778";
//        getVisitorsPerYear_uniqueData();
//        String person = "John Stevenson:2020";
//        String[] split = person.split(":");
//        hash();
//        convertAndModifyNumbers();
        getVisitorsPerYear_uniqueData();
    }
    private static void convertAndModifyNumbers(){
        StreamApiMedium sm = new StreamApiMedium();
        List<Integer> positiveNumbers = List.of(1, 3, 5, 8);
        String s = sm.convertAndModifyNumbers(positiveNumbers);
        System.out.println(s);
    }
    private static void getVisitorsPerYear_uniqueData() {
        StreamApiMedium sm = new StreamApiMedium();
        List<String> basicRecords = List.of("John Stevenson:2020", "Bruce Cage:2015",
                "Britney Johns:2005", "Brad Wang:2005", "Lee Stone:2011",
                "Rickie Garrison:2015", "Taras Kozak:2017", "Bart Swan:2018", "Brad Wang:2005");
        Long visitorsPerYear = sm.getVisitorsPerYear(basicRecords, 2005);
        System.out.println(visitorsPerYear);
    }

    private static void hash() {
        List<String> basicRecords = List.of("John Stevenson:2020", "Bruce Cage:2015",
                "Britney Johns:2005", "Brad Wang:2005", "Lee Stone:2011",
                "Rickie Garrison:2015", "Taras Kozak:2017", "Bart Swan:2018", "Brad Wang:2005");
        Map<String, Integer> mapPeople = new HashMap<>();
        for (String record : basicRecords) {
            String[] split = record.split(":");
            mapPeople.put(split[0], Integer.valueOf(split[1]));
        }
        System.out.println(mapPeople);
        mapPeople.entrySet().stream();
        basicRecords.stream().map(c -> c.split(":"));

        Map<Integer, Integer> map1 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toMap(
                        Function.identity(),
                        Function.identity()
                ));
        System.out.println(map1);
//        Map<Integer,String> mapListTemp = basicRecords.stream().collect(Collectors.toMap(y -> y.getY(), v -> v.getValue()))

//        Map<String, String> collect = basicRecords
//                .stream() //parallelStream()
//                .collect(Collectors.toMap(Function.identity(), Function.identity()));
//        System.out.println(collect);
    }
}
