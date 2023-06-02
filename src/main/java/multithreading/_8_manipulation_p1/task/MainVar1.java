package multithreading._8_manipulation_p1.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class MainVar1 {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        SumAllNumbersRecursive2 sumAllNumbersRecursive
                = new SumAllNumbersRecursive2(0, 100, 10);
        Long result = forkJoinPool.invoke(sumAllNumbersRecursive);
        System.out.println("Result " + result);
    }
}

class SumAllNumbersRecursive extends RecursiveTask<Long> {
    private int startPoint, endPoint, limitThreads;

    public SumAllNumbersRecursive(int startPoint, int endPoint, int limitThreads) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.limitThreads = limitThreads;
    }

    @Override
    protected Long compute() {
        if (endPoint - startPoint < limitThreads) {
            return (long) IntStream.range(startPoint, endPoint).sum();
        } else {
            List<RecursiveTask<Long>> tasks = new ArrayList<>(createSubTask());
            long result = 0;
            for (RecursiveTask<Long> task : tasks) {
                task.fork();
                result += task.join();
            }
            return result;
        }
    }

    private List<RecursiveTask<Long>> createSubTask() {
        List<RecursiveTask<Long>> tasks = new ArrayList<>();
        int middle = startPoint + (endPoint - startPoint) / 2;
        RecursiveTask<Long>firstPart = new SumAllNumbersRecursive2(startPoint,middle,limitThreads);
        RecursiveTask<Long>secondPart = new SumAllNumbersRecursive2(middle,endPoint,limitThreads);
        tasks.add(firstPart);
        tasks.add(secondPart);
        return tasks;
    }
}