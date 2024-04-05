package web.inf.patterns.strategy;

public class MargeSortStrategyImpl implements SortStrategy {
    @Override
    public void sort(int[] arr) {
        System.out.println("MargeSortStrategyImpl");
    }
}
