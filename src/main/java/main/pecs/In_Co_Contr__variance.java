package main.pecs;

import java.util.ArrayList;
import java.util.List;

public class In_Co_Contr__variance {
    public static void main(String[] args) {
        List<? super Number> list = new ArrayList<>(List.of(1,2));
        list.get(1);
        list.add(25);
        System.out.println(list);

        List list2 = new ArrayList<Integer>(List.of(1,2));
        list2.get(1);
        list2.add(2);

        invariance();
        covariance();
        contravariance();
    }

    public static void invariance() {
        List<Integer> integers = new ArrayList<>();
//        List<Number>numbers = integers;

        List<Number> numbers1 = new ArrayList<>();
//        List<Integer>integers1 = numbers1;
    }

    public static void covariance() {
        List<? extends Number> numbersI = new ArrayList<Integer>(List.of(1, 2));
        List<? extends Number> numbersD = new ArrayList<Double>(List.of(1.5, 2.5));
        List<? extends Number> numbers = new ArrayList<>(List.of(1.5F, 2.5F));
        numbers.get(1);
//        numbers.add(2);


        List<Cat> cats = new ArrayList<>();
        List<? extends Animal> animalsPE1 = new ArrayList<Cat>();
//        List<? extends Cat> animalsPE2 = new ArrayList<Animal>();


    }

    public static void contravariance() {
//        List<? super Animal> animalsCS1 = new ArrayList<Cat>();
        List<? super Cat> animalsCS2 = new ArrayList<Animal>();
        List<? super Animal> animalsCS3 = new ArrayList<Animal>();

        List<? super Number> numbers = new ArrayList<>(List.of(5,6.5));
        numbers.add(Integer.valueOf(5));
        numbers.add(6);
        numbers.get(1);
    }
}
