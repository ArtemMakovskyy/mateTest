package multithreading._8_manipulation_p1.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class MainVar3Practice {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Integer sum = forkJoinPool.invoke(new SumNumbers(0, 10000));
        System.out.println(sum);
    }
}

class SumNumbers extends RecursiveTask<Integer> {
    int startFrom, endTo;

    public SumNumbers(int startFrom, int endTo) {
        this.startFrom = startFrom;
        this.endTo = endTo;
    }

    @Override
    protected Integer compute() {
        if (endTo - startFrom < 1000) {
            System.out.println(Thread.currentThread().getName());
            return IntStream.range(startFrom, endTo).sum();
        } else {
            List<RecursiveTask<Integer>> tasks = new ArrayList<>(splitTasks());
            int sum = 0;
            for (RecursiveTask<Integer> task : tasks) {
                task.fork();
                sum += task.join();
            }
            return sum;
        }
    }

    private List<RecursiveTask<Integer>> splitTasks() {
        List<RecursiveTask<Integer>> tasks = new ArrayList<>();
        int quarter = (endTo - startFrom) / 4;
        tasks.add(new SumNumbers(startFrom, startFrom + quarter));
        tasks.add(new SumNumbers(startFrom + quarter, startFrom + quarter * 2));
        tasks.add(new SumNumbers(startFrom + quarter * 2, startFrom + quarter * 3));
        tasks.add(new SumNumbers(startFrom + quarter * 3, endTo));
        return tasks;
    }
}
