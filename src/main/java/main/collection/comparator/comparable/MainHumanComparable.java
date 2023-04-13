package main.collection.comparator.comparable;

import main.java8.stream.classes.p_07.model.User;
import org.apache.logging.log4j.util.PropertySource;

import java.util.*;

public class MainHumanComparable {

    public static void main(String[] args) {
        Set<HumanComparable> humanComparableList = new TreeSet<>(List.of(
                HumanComparable.of("Artem", "Makovsky", 43),
                HumanComparable.of("Elena", "Makovskaya", 46),
                HumanComparable.of("Sasha", "Makovskaya", 21),
                HumanComparable.of("Polina", "Makovskaya", 18),
                HumanComparable.of("Oksana", "Cvetanskaya", 46),
                HumanComparable.of("Andrey", "Cvetanskayy", 47)));
        humanComparableList.stream().forEach(System.out::println);
        System.out.println();


Comparator<Human> humanComparator = new Comparator<Human>() {
    @Override
    public int compare(Human human1, Human human2) {
        if (human1.getLastName().compareTo(human2.getLastName()) != 0 ){
            return human1.getLastName().compareTo(human2.getLastName());
        }
        return Integer.compare(human1.getAge(),human2.getAge());
    }
};
        Set<Human>humanTreeSet = new TreeSet<>(Human.compareByLastNameNameAge);
        humanTreeSet.add(Human.of("Artem", "Makovsky", 43));
        humanTreeSet.add(Human.of("Elena", "Makovskaya", 45));
        humanTreeSet.add(Human.of("Sasha", "Makovskaya", 21));
        humanTreeSet.add(Human.of("Oksana", "Cvetanskaya", 46));
        humanTreeSet.add(Human.of("Oksana", "Cvetanskaya", 46));
        humanTreeSet.add(Human.of("Andrey", "Cvetanskayy", 47));
        humanTreeSet.stream().forEach(System.out::println);
        System.out.println();


        List<Human>humanList = new ArrayList<>();
        humanList.add(Human.of("Artem", "Makovsky", 43));
        humanList.add(Human.of("Elena", "Makovskaya", 45));
        humanList.add(Human.of("Sasha", "Makovskaya", 21));
        humanList.add(Human.of("Oksana", "Cvetanskaya", 46));
        humanList.add(Human.of("Oksana", "Cvetanskaya", 46));
        humanList.add(Human.of("Andrey", "Cvetanskayy", 47));
        humanList.stream().sorted(new Comparator<Human>() {
            @Override
            public int compare(Human human1, Human human2) {
                int intLastName = human1.getLastName().compareTo(human2.getLastName());
                int intName = human1.getName().compareTo(human2.getName());
                if (intLastName != 0) return intLastName;
                if (intName != 0) return intName;
                return Integer.compare(human1.getAge(), human2.getAge());
            }
        }).forEach(System.out::println);


    }
}
