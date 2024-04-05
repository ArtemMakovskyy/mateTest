package multithreading.all.in.one;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class D00_ForkJoinPool_MyRecursiveAction {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        RecursiveAction recursiveAction = new MyRecursiveAction(100);
        forkJoinPool.invoke(recursiveAction);
        Thread.sleep(500);
    }
}

class MyRecursiveAction extends RecursiveAction {
    private static final int MAXIMUM_QUANTITY_FOR_PROCESSING = 25;
    private final long numberOfTasks;

    public MyRecursiveAction(long numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }

    @Override
    protected void compute() {
        if (numberOfTasks > MAXIMUM_QUANTITY_FOR_PROCESSING) {
            splitTask();
        } else {
            doHardProcess();
        }
    }

    private List<RecursiveAction> createSubTasks() {
        RecursiveAction first = new MyRecursiveAction(numberOfTasks / 2);
        RecursiveAction second = new MyRecursiveAction(numberOfTasks / 2);
        return List.of(first, second);
    }

    private void splitTask() {
        System.out.println("workload > THRESHOLD. It will split. "
                + numberOfTasks + " "
                + Thread.currentThread().getName());
        final List<RecursiveAction> subTasks = createSubTasks();
        for (RecursiveAction subTask : subTasks) {
            subTask.fork();
        }
    }

    private void doHardProcess() {
        try {
            Thread.sleep(250);
            System.out.println("Doing task, workload: "
                    + numberOfTasks + " "
                    + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
