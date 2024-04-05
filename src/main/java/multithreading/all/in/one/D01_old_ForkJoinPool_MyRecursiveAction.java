package multithreading.all.in.one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class D01_old_ForkJoinPool_MyRecursiveAction {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        MyRecursiveActionOld task = new MyRecursiveActionOld(0, 100);
        Long result = forkJoinPool.invoke(task);
        System.out.println("Result = " + result);

    }
}

class MyRecursiveActionOld extends RecursiveTask<Long> {
    private int startPoint;
    private int finishPoint;

    public MyRecursiveActionOld(int startPoint, int finishPoint) {
        this.startPoint = startPoint;
        this.finishPoint = finishPoint;
    }

    @Override
    protected Long compute() {
        if (finishPoint - startPoint > 10) {
            List<RecursiveTask<Long>> subTasks = new ArrayList<>(createSubTask());
            for (RecursiveTask<Long> subTask : subTasks) {
                subTask.fork();
            }
            long result = 0;
            for (RecursiveTask<Long> subTask : subTasks) {
                result += subTask.join();
            }
            return result;
        } else {
            return (long) IntStream.range(startPoint, finishPoint).sum();
        }
    }

    private List<RecursiveTask<Long>> createSubTask() {
        List<RecursiveTask<Long>> subTasks = new ArrayList<>();
        int middlePoint = startPoint + ((finishPoint - startPoint) / 2);
        RecursiveTask<Long> firstHalf = new MyRecursiveActionOld(startPoint, middlePoint);
        RecursiveTask<Long> secondHalf = new MyRecursiveActionOld(middlePoint, finishPoint);
        subTasks.add(firstHalf);
        subTasks.add(secondHalf);
        return subTasks;
    }
}
