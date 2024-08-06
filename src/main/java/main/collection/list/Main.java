package main.collection.list;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        Person artem = new Person("Artem43",43,"male");
        Person artem18 = new Person("Artem18",18,"m");
        Person artem27 = new Person("Artem27",27,"male");

        ListFilter lf = new ListFilter();
        personList.add(artem);
        personList.add(artem18);
        personList.add(artem27);
        System.out.println(lf.filter(personList));
        personList.stream().map(i-> i.getAge()).forEach(System.out::println);
        System.out.println();
        personList.stream().map(Person::getName).forEach(System.out::println);
        System.out.println();
        personList.stream().filter(i-> i.getAge() > 19).forEach(System.out::println);


//        personList.stream().filter(i-> i.getAge();

    }
}
