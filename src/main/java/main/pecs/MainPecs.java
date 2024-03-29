package main.pecs;

import main.pecs.wildCard.Animal;
import main.pecs.wildCard.Cat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainPecs {
    public static void main(String[] args) {
        practice();
        List<Double> invariant = new ArrayList<>();
        invariant.add(Double.valueOf(1));
        invariant.add(Double.valueOf(1.5));
        System.out.println(invariant);
        System.out.println(invariant.get(1));

        List<?> covariant = new ArrayList<>();
//        question.add(Integer.valueOf(1));
        covariant.get(0);

        List<? extends Number> covariant2 = new ArrayList<>();
//        covariant.add(Integer.valueOf(1));
        covariant.get(0);

        List<? super Number> contrvariant = new ArrayList<>();

    }

    public static void practice() {

    }

    public static void wildCard_FirstLesson() {
        //        Invariance
        System.out.println("THIS DON'T WORK   List<Number>myNumsInvariance = myInt;");
//        List<Number>myNumsInvariance = myInt;
        List<Integer> myInt = new LinkedList<>();
        Cat cat = new Cat("Marsik");
        Animal animal = cat;


        List<Number> listNumber = new ArrayList<>();
        listNumber.add(Integer.valueOf(5));
        System.out.println(listNumber.get(0));

//        Covariance
        List<? extends Number> numbersInteger = new ArrayList<Integer>();
        List<? extends Number> numbersDouble = new ArrayList<Double>();
//        List<? extends Number> numbersString = new ArrayList<String>();
        List<Cat> cats = new LinkedList<>();
        List<? extends Animal> animals = cats;

        List<Object> objects = new ArrayList<>();
        List<? extends Object> animalsOb = objects;

//        Contravariance
        List<? super Number> numbers = new ArrayList<>();
        numbers.add(Integer.valueOf(10));
        numbers.add(Double.valueOf(10.15));
        numbers.add(Float.valueOf(10.20F));
        System.out.println(numbers.get(1));


    }
}
