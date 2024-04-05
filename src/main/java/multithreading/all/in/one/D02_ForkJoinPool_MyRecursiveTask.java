package multithreading.all.in.one;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class D02_ForkJoinPool_MyRecursiveTask {
    public static void main(String[] args) {
            var1();
            var2();
    }

    private static void var1() {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        int[] numbers = {14, 8, 20, 5, 33, 12, 26, 7};
        MaxElementTask maxElementTask = new MaxElementTask(numbers);
        final Integer maxElement = forkJoinPool.invoke(maxElementTask);
        System.out.println(maxElement);
    }

    private static void var2() {
        int[] numbers = {14, 8, 20, 5, 33, 12, 26, 7};
        MaxElementTask maxElementTask = new MaxElementTask(numbers);
        final Integer maxElement = maxElementTask.invoke();
        System.out.println(maxElement);
    }
}

class MaxElementTask extends RecursiveTask<Integer> {
    private final int[] array;
    int start, end;
    private static final int THRESHOLD = 4;

    public MaxElementTask(int[] array) {
        this(array, 0, array.length);
    }

    private MaxElementTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        final Integer rightResult;
        final Integer leftResult;
        if (end - start <= THRESHOLD) {
            System.out.println("start " + start + ",end " + end + ", " + Thread.currentThread().getName());
            return findMAx(array, start, end);
        } else {
            System.out.println("start " + start + ",end " + end + ", " + Thread.currentThread().getName());
            int middle = start + (end - start) / 2;
            MaxElementTask leftTask = new MaxElementTask(array, start, middle);
            MaxElementTask rightTask = new MaxElementTask(array, middle, end);

            if (true) {
                leftTask.fork();
                rightTask.fork();
                rightResult = rightTask.join();
                leftResult = leftTask.join();
                return Math.max(rightResult, leftResult);
            } else {
                leftTask.fork();
                rightResult = rightTask.compute();
                leftResult = leftTask.join();
                return Math.max(rightResult, leftResult);
            }

        }
    }

    private Integer findMAx(int[] array, int start, int end) {
        int max = array[start];
        for (int i = start + 1; i < end; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}