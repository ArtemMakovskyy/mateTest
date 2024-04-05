package web.inf.patterns.strategy;

public class BubbleSortStrategyImpl implements SortStrategy {
    @Override
    public void sort(int[] arr) {
        System.out.println("BubbleSortStrategyImpl");
    }
}
