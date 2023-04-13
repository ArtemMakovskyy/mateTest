package main.java8.stream.classes.tregulov.gropingby;

import main.java8.stream.classes.model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainGroupingBy {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Ivan", 'm', 19, 3, 8.3),
                new Student("Nik", 'm', 28, 2, 6.4),
                new Student("Elena", 'f', 19, 1, 8.9),
                new Student("Petr", 'm', 35, 4, 7),
                new Student("Mariya", 'f', 23, 3, 7.4)
        );
        Stream<Student> studentStream = students
                .stream().map(el -> {
                    el.setName(el.getName().toUpperCase());
                    return el;
                })
                .sorted(sortByAge);
        Map<Integer, List<Student>> collectByCourse = studentStream.collect(Collectors.groupingBy(el -> el.getCourse()));
        for (Map.Entry<Integer,List<Student>> entry : collectByCourse.entrySet() ){
            System.out.print(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    private static final Comparator<Student> sortByAge = (o1, o2) -> {
        int compareAge = Integer.compare(o1.getAge(), o2.getAge());
        int compareToName = o1.getName().compareTo(o2.getName());
        if (compareAge != 0) {
            return compareAge;
        }
            return compareToName;
    };
}

class Another{

}