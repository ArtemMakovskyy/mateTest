package web.inf.patterns.strategy;

public class Main {
    public static void main(String[] args) {
//        ArraySorter arraySorter = new ArraySorter(new BubbleSortStrategyImpl());
        ArraySorter arraySorter = new ArraySorter(new MargeSortStrategyImpl());
        int[] arr = new int[]{1, 3, 8, 5, 3, 4, 10, 3, 3, 4};
        arraySorter.sort(arr);
    }
}
