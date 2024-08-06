package live.coding.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Training {
    public static void main(String[] args) {

//        a();
//        b();
//        с();
        d();
    }

    private static void d() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        numbers.add(60);

        // Печатаем исходный список
        System.out.println("Исходный список: " + numbers);

        // Удаляем элементы с четных позиций
        List<Integer> result =
                IntStream
                        .range(0, numbers.size())
                        .filter(i -> i % 2 != 0)
                        .mapToObj(index -> numbers.get(index))
                        .map(data -> data + 1)
                        .collect(Collectors.toList());

        // Печатаем результат
        System.out.println("Результат: " + result);

        IntStream.range(0, numbers.size())
                .forEach(i -> {
                    if (i % 2 == 0) {
                        // Чётные позиции (индексы 0, 2, 4,...)
                        numbers.set(i, 0);
                    } else {
                        // Нечётные позиции (индексы 1, 3, 5,...)
                        numbers.set(i, numbers.get(i) + 1);
                    }
                });
    }

    private static void с() {
        int[] intArr2 = new int[]{0, 5, 3, 8};
//        for (int i = 0; i < intArr2.length; i++) {
//            System.out.println(i);
//        }

//        IntStream.of(intArr2).map(i -> i + 10).forEach(System.out::println);
//        final int[] intArr1 = IntStream.of(intArr2).map(i -> i + 10).toArray();
//        System.out.println();
//        IntStream.of(intArr2).forEach(System.out::println);

        int result = IntStream.of(1, 2, 7).reduce(0, (a, b) -> a + b); // 6
        System.out.println(result);
    }

    private static void b() {
        List<String> collect1 = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
        List<String> collect2 = new ArrayList<>(Arrays.asList("banana", "cherry", "date"));

//        collect2.retainAll(collect1);
        collect2.containsAll(collect1);


        System.out.println(collect2.containsAll(collect1));

    }

    ;

    private static void a() {
        int[] intArr1 = new int[]{5, 3, 8, 3, 6, 5, 84, 2};
        int[] intArr2 = new int[]{0, 5, 3, 8, 41};
        final List<Integer> collect1 = Arrays.stream(intArr1).boxed().collect(Collectors.toList());
        final List<Integer> collect2 = Arrays.stream(intArr2).boxed().collect(Collectors.toList());
        System.out.println(collect1.contains(5));
        System.out.println(collect1.lastIndexOf(3));
        System.out.println(collect1.indexOf(3));

        collect2.retainAll(collect1);

        System.out.println(collect2);

    }
}
