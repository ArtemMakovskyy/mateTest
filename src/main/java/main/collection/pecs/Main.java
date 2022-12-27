package main.collection.pecs;

import main.collection.pecs.wildCard.Animal;
import main.collection.pecs.wildCard.Cat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {



    }
    public static void wildCard_FirstLesson(){
        //        Invariance
        System.out.println("THIS DON'T WORK   List<Number>myNumsInvariance = myInt;");
//        List<Number>myNumsInvariance = myInt;
        List<Integer> myInt = new LinkedList<>();
        Cat cat = new Cat("Marsik");
        Animal animal = cat;


        List<Number>listNumber = new ArrayList<>();
        listNumber.add(Integer.valueOf(5));
        System.out.println(listNumber.get(0));


//        Covariance
        List<? extends Number> numbersInteger = new ArrayList<Integer>();
        List<? extends Number> numbersDouble = new ArrayList<Double>();
//        List<? extends Number> numbersString = new ArrayList<String>();
        List<Cat> cats = new LinkedList<>();
        List<? extends Animal> animals = cats;

        List<Object>objects = new ArrayList<>();
        List<? extends Object> animalsOb = objects;

//        Contravariance
        List<? super Number> numbers = new ArrayList<>();
        numbers.add(Integer.valueOf(10));
        numbers.add(Double.valueOf(10.15));
        numbers.add(Float.valueOf(10.20F));
    }
}
