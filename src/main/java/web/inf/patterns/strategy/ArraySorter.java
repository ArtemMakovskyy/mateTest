package web.inf.patterns.strategy;

public class ArraySorter {
    private SortStrategy strategy;

    public ArraySorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[]array){
        strategy.sort(array);
    }
}
