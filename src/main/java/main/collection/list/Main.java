package main.collection.list;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        ListFilter lf = new ListFilter();
        Person artem = new Person("Artem",43,"male");
        Person artem18 = new Person("Artem18",18,"m");
        Person artem27 = new Person("Artem27",27,"male");
        personList.add(artem);
        personList.add(artem18);
        personList.add(artem27);
        System.out.println(lf.filter(personList));

    }
}
