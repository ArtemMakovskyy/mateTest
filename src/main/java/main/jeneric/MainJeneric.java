package main.jeneric;

import java.util.ArrayList;

public class MainJeneric {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(1, "hello");
        Integer key = pair.getKey(); // 1
        String value = pair.getValue(); // "hello"
        System.out.println(key + ", " + value);

        Pair<Integer, String> secondPair = new Pair<>(1, "hello");
        boolean mustBeTrue = pair.equals(secondPair); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == secondPair.hashCode(); // true!

        System.out.println(mustBeTrue + ", " + mustAlsoBeTrue);

        Integer i1 = 1;
        Integer i2 = 2;
        Float f = 25.15f;
        String s = "S";
        System.out.println(i1.equals(i2));

        System.out.println(i1.getClass());
        System.out.println(f.getClass());
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Float> fl = new ArrayList<>();
        System.out.println(al.getClass());
        System.out.println(fl.getClass());


    }
}
