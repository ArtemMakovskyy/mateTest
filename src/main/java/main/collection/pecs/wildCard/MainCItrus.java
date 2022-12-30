package main.collection.pecs.wildCard;

import java.util.ArrayList;

public class MainCItrus {

    static class Fruit {
        int weight;
    }

    static class Citrus extends Fruit {
        int weight;
    }

    static class Orange extends Citrus {
        int color;
    }

    static class BigRoundOrange extends Orange {
        int size = 100;
    }

    private static int totalWeightOrange(ArrayList<? extends Citrus> item) {
        int weight = 0;
        for (int i = 0; i < item.size(); i++) {
            weight =+ item.get(i).weight;
        }
        Fruit fruit = item.get(0);
        Citrus citrus = item.get(0);
        return weight;
    }

    private static void addOrange(ArrayList<? super Orange> oranges) {
        for (int i = 0; i < 10; i++) {
            oranges.add(new Orange());
        }
        oranges.add(new BigRoundOrange());
        Object ob = oranges.get(0);
        Orange or = (Orange) oranges.get(0);
    }

    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        Citrus citrus = new Citrus();
        Orange orange = new Orange();
        BigRoundOrange bro = new BigRoundOrange();

        fruit = citrus;
        fruit = orange;
        fruit = bro;

        citrus = orange;
        citrus = bro;
        citrus = (Citrus) fruit;
        bro = (BigRoundOrange) fruit;

        ArrayList<Citrus> citruses = new ArrayList<>();
        citruses.add(new Citrus());
        citruses.add(new Citrus());

        ArrayList<Orange> oranges = new ArrayList<>();
        citruses.add(new Citrus());
        citruses.add(new Citrus());

        fruit = citruses.get(0);
        citrus = citruses.get(0);
//        orange = (Orange) citruses.get(0);
//        bro = (BigRoundOrange) citruses.get(0);

        totalWeightOrange(citruses);
        totalWeightOrange(oranges);

        addOrange(oranges);
        addOrange(citruses);


    }
}
