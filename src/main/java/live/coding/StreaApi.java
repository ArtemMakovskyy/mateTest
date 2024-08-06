package live.coding;

import static main.excersise.Main.calculateSum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import lombok.Data;
import tasks.other.FindOutMain;

public class StreaApi {
    private final static List<Integer> INTEGER_LIST = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private final static int[] INT_ARR = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final static List<String> FRUITS = Arrays.asList("apple", "banana", "cherry", "date", "kiwi", "fig", "grape");

    public static void main(String[] args) {
//        filterOdd();
//        listStringsToListlengthInts();
//        sortStrings();
//        maxAndMin();
//        fetNamesLes4AndGetInApperCase();
//        getEmplWithMaxSal();
//        groupWordsByLength();
        manipulationArr();
    }

    private static void manipulationArr() {
        Arrays.stream(INT_ARR).distinct().forEach(System.out::println);
        String str = "Hello";
        final IntStream charsStr = str.chars();
        charsStr.forEach(StreaApi::accept);
    }

    private static void groupWordsByLength() {
        final Map<Integer, List<String>> collectWords = FRUITS.stream()
//                .collect(Collectors.groupingBy(word -> word.length()))
                .collect(Collectors.groupingBy(String::length));
        collectWords.forEach((length, words) -> System.out.println(length + " " + words));
    }

    private static void getEmplWithMaxSal() {
        List<Emp> employees = Arrays.asList(
                new Emp("John", 50000),
                new Emp("Jane", 75000),
                new Emp("Doe", 60000)
        );

        final double averageSalary = employees.stream()
                .mapToInt(Emp::getSalary)
                .average()
                .orElse(0);
        System.out.println(averageSalary);


        final Emp emp = employees.stream()
//                .max((emp1, emp2) -> (Integer.compare(emp1.getSalary(), emp2.getSalary())))
                .max(Comparator.comparingInt(Emp::getSalary))
                .get();
        System.out.println(emp);


        final Emp emp1 = employees.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
                .findFirst().get();
        System.out.println(emp1);


    }

    private static void fetNamesLes4AndGetInApperCase() {
        FRUITS.stream()
                .filter(name -> name.length() < 6)
                .map(name -> name.toUpperCase())
                .forEach(System.out::println);
    }


    private static void maxAndMin() {
        final Optional<Integer> max = INTEGER_LIST.stream()
                .max((integer, anotherInteger) -> integer.compareTo(anotherInteger));

        final Optional<Integer> max2 = INTEGER_LIST.stream()
                .max(Integer::compareTo);
    }

    private static void sortStrings() {
        FRUITS.stream()
                .sorted()
                .forEach(System.out::println);

    }

    private static void listStringsToListlengthInts() {
        FRUITS.stream()
                .map(fruit -> fruit.length())
                .forEach(System.out::println);
    }

    static void filterOdd() {
        final List<Integer> collect = INTEGER_LIST.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    private static void accept(int a) {
        System.out.println((char) a);
    }
}

@AllArgsConstructor
@Data
class Emp {
    private String name;
    private int salary;
}