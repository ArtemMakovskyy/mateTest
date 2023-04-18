package multithreading._8_manipulation._4.fork.join.pool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        switcher(2);
    }

    static void recursiveAction() throws InterruptedException {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        RecursiveAction myRecAct = new MyRecursiveAction(1000);
        forkJoinPool.invoke(myRecAct);
        Thread.sleep(1000); //waiting for tje massages to be printed put
    }

    static void recursiveTask() throws InterruptedException {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        RecursiveTask<Long> myRecursiveTask = new MyRecursiveTask(128);
        long margeResult = forkJoinPool.invoke(myRecursiveTask);
        System.out.println("margeResult " + margeResult);
        Thread.sleep(1000); //waiting for tje massages to be printed put
    }

    static void switcher(int taskNumber) throws InterruptedException {
        switch (taskNumber) {
            case 1:
                recursiveAction();
                break;
            case 2:
                recursiveTask();
                break;
            default:
                System.err.println("should choose from 1 to 2");
        }
    }
}
