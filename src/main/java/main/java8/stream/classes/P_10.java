package main.java8.stream.classes;

import lombok.*;

import java.io.File;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P_10 {
    //    https://www.youtube.com/watch?v=HOQpQWK9u28
    public static void main(String[] args) {
        grupingBy1();
//        grupingBy2();


    }

    private static void grupingBy2() {
//        15min
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 9);

        Function<File, String> classifier = a -> a.getName().substring(a.getName().lastIndexOf(".") + 1);

        Map<String, List<File>> collect = Arrays.stream(new File("folder").listFiles())
                .collect(Collectors.groupingBy(classifier));
        System.out.println(collect);
    }

    private static void grupingBy1() {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 9);

        Function<Integer, String> keyMapper = a -> a % 2 == 0 ? "even" : "odd";

        Map<String, List<Integer>> collect = integerList.stream()
                .collect(Collectors.groupingBy(keyMapper));

        System.out.println(collect);
    }

    private static void toMAp2() {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 9);

        Function<Integer, String> keyMapper = a -> a % 2 == 0 ? "even" : "odd";

        Function<Integer, List<Integer>> valueMapper = a -> List.of(a);

        BinaryOperator<List<Integer>> mergeFunction = (a, b) -> {
            List<Integer> result = new ArrayList<>(a);
            result.addAll(b);
            return result;
        };

        Supplier<Map<String, List<Integer>>> supplier = () -> new HashMap<String, List<Integer>>();

        Map<String, List<Integer>> result = integerList.stream()
                .collect(Collectors.toMap(keyMapper, valueMapper, mergeFunction, supplier));
//        .collect(Collectors.toMap(
//        как генерировать ключ
//        , как генерировать значение
//        , операция которая будет вызываться при добавлении существующего ключа на значение
//        , в какую карту упаковать результат));
        System.out.println(result);


    }

    private static void toMAp1() {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);

        Map<Integer, String> integerStringMap = integerList.stream()
                .collect(Collectors.toMap(Function.identity(), a -> a % 2 == 0 ? "even" : "odd"));

        System.out.println(integerStringMap);
    }

    private static void minMaxSort() {
        String[] name = new String[]{"9Artem", "Ivan", "Boris", "Kyiv", "London", "5Paris"};
        Arrays.stream(name).sorted().forEach(System.out::println);

        Student studentMin = getStudents().stream()
                .min((x, c) -> x.getAge() - c.getAge()).get();
        System.out.println(studentMin);

        Student studentMax = getStudents().stream()
                .max(Comparator.comparingInt(Student::getAge)).get();
        System.out.println(studentMax);

        System.out.println();
        getStudents().stream()
                .sorted(Comparator.comparingInt(student -> student.getAge()))
                .forEach(System.out::println);

    }

    private static void grupingBy() {

        Map<Integer, List<Student>> collect = getStudents().stream()
                .map(el -> {
                    el.setName(el.getName().toUpperCase());
                    return el;
                }).collect(Collectors.groupingBy(el -> el.getCource()));


        Map<Sex, List<Student>> sexListMap = getStudents().stream()
                .collect(Collectors.groupingBy(el -> el.getSex()));

        Map<Boolean, List<Student>> gradeMore25 = getStudents().stream()
                .collect(Collectors.partitioningBy(el -> el.getGrade() > 25));

        getStudents().stream();


    }

    private static void flatMap_arr() {
        List<String> basicInput = List.of("8,14,5", "3,-22,800", "-71", "20,98,45,98",
                "1,49,2,5", "27,12,89", "56,3,5", "12,-22,320");

        Integer integer = basicInput.stream()
                .flatMap(nums -> Arrays.stream(nums.split(",")))
                .map(c -> Integer.parseInt(c))
                .sorted()
                .findFirst().get();

        System.out.println(integer);

        Integer integer1 = basicInput.stream()
                .map(s -> s.split(","))
                .flatMap(Stream::of)
                .map(c -> Integer.parseInt(c))
                .sorted()
                .findFirst().get();

        System.out.println(integer1);

        String s = basicInput.stream()
                .min((x, y) -> Integer.parseInt(x) - Integer.parseInt(y)).get();
        System.out.println(s);

    }

    private static void flatMap_innerList() {
        studentsByGender().stream()
                .flatMap(s -> s.getStudentList().stream())
                .forEach(System.out::println);
    }

    private static List<Faculty> studentsByGender() {
        List<Student> studentsMan = getStudents().stream()
                .filter(student -> student.getSex().equals(Sex.MAN))
                .collect(Collectors.toList());
        List<Student> studentsWoman = getStudents().stream()
                .filter(student -> student.getSex().equals(Sex.WOMAN))
                .collect(Collectors.toList());

        Faculty facultyEconomiks = new Faculty(studentsMan);
        Faculty facultyByologic = new Faculty(studentsWoman);
        return List.of(facultyEconomiks, facultyByologic);
    }

    private static List<Student> getStudents() {
        return List.of(new Student("Ivan", Sex.MAN, 25, 1, 25.5),
                new Student("Artem", Sex.MAN, 24, 2, 24.5),
                new Student("Lena", Sex.WOMAN, 36, 3, 26.5),
                new Student("Dasha", Sex.WOMAN, 22, 1, 28.5),
                new Student("Anatoly", Sex.MAN, 25, 2, 24.5),
                new Student("Ivanna", Sex.WOMAN, 25, 3, 24.5),
                new Student("Georgy", Sex.MAN, 25, 1, 24.5),
                new Student("Zenon", Sex.MAN, 25, 2, 24.5),
                new Student("Don", Sex.MAN, 25, 1, 24.5),
                new Student("Petr", Sex.MAN, 25, 3, 24.5),
                new Student("Grisha", Sex.MAN, 25, 3, 24.5),
                new Student("Polina", Sex.WOMAN, 25, 1, 22.5));
    }
}

@AllArgsConstructor
@ToString
@Getter
class Faculty {
    List<Student> studentList;
}

@AllArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
class Student implements Comparator<Student> {
    private String name;
    private Sex sex;
    private int age;
    private int cource;
    private double grade;

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}

enum Sex {
    MAN, WOMAN;
}