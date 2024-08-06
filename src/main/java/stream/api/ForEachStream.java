package stream.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForEachStream {
    public static void main(String[] args) {
        instedForeI();
        emplManipulation();
    }

    private static void emplManipulation() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30));
        employees.add(new Employee("Bob", 25));
        employees.add(new Employee("Charlie", 35));
        employees.add(new Employee("David", 40));
        employees.add(new Employee("Eve", 22));
        employees.add(new Employee("Frank", 29));
        employees.add(new Employee("Grace", 33));
        employees.add(new Employee("Hank", 31));
        employees.add(new Employee("Ivy", 28));
        employees.add(new Employee("Jack", 26));

        // Увеличение возраста каждого нечетного по индексу сотрудника на единицу
        List<Employee> updatedEmployees = IntStream.range(0, employees.size())
                .mapToObj(index -> {
                    Employee emp = employees.get(index);
                    if (index % 2 != 0) {
                        return new Employee(emp.getName(), emp.getAge() + 1);
                    } else {
                        return emp;
                    }
                })
                .collect(Collectors.toList());

        // Вывод списка сотрудников после обновления
        updatedEmployees.forEach(System.out::println);

    }

    private static void instedForeI() {
        final List<Integer> collect = IntStream.range(0, 10)
                .boxed()
                .collect(Collectors.toList());
    }


}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + "}";
    }
}