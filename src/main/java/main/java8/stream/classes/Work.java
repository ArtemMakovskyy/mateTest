package main.java8.stream.classes;



import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Work {
    public static void main(String[] args) {
//        second();
//        third();
        fourth();
//        five();



    }
    private static void five() {
//        List<String> basicInput = List.of("08:John", "119:Anthony", "019:Nicolas",
//                "037:Brad", "056:Britney", "043:Annie", "019:Jorge", "001:Bruce");
//        Long expected = 119L;
//        StreamApiMedium sam = new StreamApiMedium();
//        Long oldestPersonAge = sam.getOldestPersonAge(basicInput);
//        System.out.println(oldestPersonAge);
    }
    private static void fourth() {
//        StreamApiMedium sam = new StreamApiMedium();
//        System.out.println(sam.charsIncrementation("ASD",1));

//        String value = "D";
//        int valueChar = value.charAt(0);
//        String next = String.valueOf((char) (valueChar + 1));
//        System.out.println(next);
//
//        String next2 = String.valueOf((char) (value.charAt(0) + 1));


    }

    private static void third() {
//        List<Integer> positiveNumbers = List.of(1, 3, 5, 8);
//        String expected = "(1)" + System.lineSeparator() + "(11)"
//                + System.lineSeparator() + "(101)" + System.lineSeparator() + "(1000)";
//        StreamApiMedium sam = new StreamApiMedium();
//        System.out.println(sam.convertAndModifyNumbers(positiveNumbers));
//        Assert.assertEquals(
//                String.format("convertAndModifyNumber: Incorrect result for input - %s."
//                                + System.lineSeparator(),
//                        positiveNumbers),
//                expected, javaStreamApi.convertAndModifyNumbers(positiveNumbers));
    }

    private static void second() {
//        Map<String, Integer> basicInput = Map.of(
//                "Clarity", 2_000, "Oracle", 50_000,
//                "MicroSystem", -2_000, "Odyssey", -100, "Jupiter", 200,
//                "Infinity", 2_000_000, "Destiny", 0);
//        List<String> expected = List.of("Clarity", "Infinity", "Jupiter", "Oracle");
//        StreamApiMedium sam = new StreamApiMedium();
//        System.out.println(sam.getCompanies(basicInput));
//        Assert.assertEquals(
//                String.format("getCompanies: Incorrect result companies for input - %s."
//                        + System.lineSeparator(), basicInput),
//                expected, javaStreamApi.getCompanies(basicInput));
    }

    private static void first() {
        Map<Integer, Integer> map1 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toMap(
                        Function.identity(),
                        Function.identity()
                ));
        System.out.println(map1);
        Map<Integer, String> map2 = Stream.of(1, 2, 3)
                .collect(Collectors.toMap(
                        Function.identity(),
                        i -> String.format("%d * 2 = %d", i, i * 2)
                ));
        System.out.println(map2);
        Map<Character, String> map3 = Stream.of(50, 54, 55)
                .collect(Collectors.toMap(
                        i -> (char) i.intValue(),
                        i -> String.format("<%d>", i)
                ));
        System.out.println(map3);
    }

    private void info() {
        List<Integer> results = new ArrayList<>();
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7);

        results.add(integerList.stream().reduce(Integer::min).get());
        results.add(integerList.stream().reduce((a, b) -> a * b).get());
        results.add(integerList.stream().filter(a -> a % 2 != 0).reduce(Integer::sum).get());
        results.add(integerList.stream().map(a -> a - 1).findFirst().get());
        System.out.println(results);
        Integer[] integers = integerList.toArray(new Integer[0]);
        double[] doubles = integerList.stream().mapToDouble(a -> a).toArray();
        System.out.println(Arrays.toString(doubles));
    }
}
