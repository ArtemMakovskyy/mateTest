package main.collection.pecs.wildCard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WildCard {
    public static void main(String[] args) {
        List<String> strings = List.of("Hello", "World", "generics");
        List<Integer> integerList = List.of(10, 20, 30);
        List<Animal>animals = new ArrayList<>();
        List<Cat>cats = new ArrayList<>();

        printListWildCard(strings);
        printListWildCard(integerList);
        printListWildCard(animals);
        printListWildCard(cats);

        printListWildCardExtends(animals);
        printListWildCardExtends(cats);
    }

    public static void printListWildCard(Collection<?> list) {
        System.out.println("if we don't know, what is the type of date is come in");
        for (Object object : list) {
            System.out.println(object);
        }
    }

    public static void printListWildCardExtends(Collection<? extends Animal> list) {
        System.out.println("if we don't know, what is the type of date is come in");
        for (Object object : list) {
            System.out.println(object);
        }
    }

    public static <T> void printListGeneric(Collection<T> list) {
        System.out.println("if we know, what is the type of date is come in");
        for (Object object : list) {
            System.out.println(object);
        }
    }

}
