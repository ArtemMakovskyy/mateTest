package tasks;

import java.util.List;
import java.util.stream.Collectors;

public class PersonNames {
    public  List<String> getPersonNames(List<Person> persons) {
        return persons.stream().filter(p -> p.getAge() > 30).map(s -> s.getName()).collect(Collectors.toList());
    }
}
