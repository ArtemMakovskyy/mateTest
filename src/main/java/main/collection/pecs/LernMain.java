package main.collection.pecs;

import java.util.ArrayList;
import java.util.List;

public class LernMain {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        List<Double> doubleList = List.of(1.1, 2.1, 3.1, 4.1, 5.1);
        List<String> stringList = List.of("1.1", "2.1", "3.1", "4.1", "5.1");
        print(integerList);
        print(doubleList);
        print(stringList);

        print_2(integerList);
        print_2(doubleList);

        Animal animal1 = new Animal("an1", 5, 25);
        Animal animal2 = new Animal("an2", 6, 26);
        List<Animal> animalList = List.of(animal1, animal2);
        Dog dog1 = new Dog("Dog1", 1, 30);
        Dog dog2 = new Dog("Dog2", 3, 33);
        List<Dog> dogList = List.of(dog1, dog2);
        Cat cat1 = new Cat("Cat1", 3, 55);
        Cat cat2 = new Cat("Cat2", 33, 5);
        List<Cat> catList = List.of(cat1, cat2);
        print(animalList);
        print(dogList);
        print(catList);
        print_3(dogList);
        print_4(animalList);
        print_5(dogList);
        print_5(animalList);

        print_6(dogList);
        print_7(catList, new Cat("murzik", 1, 2));
        List<? super Animal>liustQ = new ArrayList<>();
        liustQ.add(dog1);
        liustQ.add(cat1);
        for (int i = 0; i < liustQ.size(); i++) {
            Object object = liustQ.get(i);
            Animal animalAge = (Animal) object;
            System.out.println(animalAge.age);

            Animal animalAge2 = (Animal) liustQ.get(i);
            System.out.println(animalAge2.age);
        }
    }

    static void print_10(List<? super Cat> list) {
        List<Cat>catList = new ArrayList<>();
//        catList.add(list.get(0));
        list.add(new Cat("cxz",2,2));
    }
    static <T extends Animal> T print_9(List<T> list, T data) {
        return null;
    }

    static <T extends A & B> void print_8(List<T> list, T data) {
        System.out.println("print_6");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    static <T> void print_7(List<T> list, T data) {
        System.out.println("print_6");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    static <T> void print_6(List<T> list) {
        System.out.println("print_6");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    static void print_5(List<? super Dog> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    static void print_4(List<? super Animal> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    static void print_3(List<? extends Animal> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    static void print_2(List<? extends Number> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    static void print(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
