package callection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet1 = new TreeSet<>(Set.of(1, 3, 9, 5, 7));
        System.out.println(treeSet1);
        System.out.println(treeSet1.first());
        System.out.println(treeSet1.last());
        System.out.println(treeSet1.lower(5));
        System.out.println(treeSet1.higher(5));
        System.out.println(treeSet1.floor(100));
        System.out.println(treeSet1.ceiling(6));
        System.out.println(treeSet1.contains(6));




    }
}
