package main.collection.set;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference<T> {
    public Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set1Tree = new HashSet<>(set1);
        Set<T> set2Tree = new HashSet<>(set2);
        set1Tree.removeAll(set2);
        set2Tree.removeAll(set1);
        set1Tree.addAll(set2Tree);
        return set1Tree;
    }
}
