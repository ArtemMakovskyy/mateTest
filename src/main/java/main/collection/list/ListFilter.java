package main.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListFilter {
    public List<Person> filter(List<Person> personList) {
        List<Person> peopleFilters = new ArrayList<>();
        if (personList == null || personList.size() == 0) {
            return peopleFilters;
        }
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getAge() >= 18
                    && personList.get(i).getAge() <= 27
                    && personList.get(i).getSex().equals("male")) {
                peopleFilters.add(personList.get(i));
            }
        }
        return peopleFilters;
    }
}
