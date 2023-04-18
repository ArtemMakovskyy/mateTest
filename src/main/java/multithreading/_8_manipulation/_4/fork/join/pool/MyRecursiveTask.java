package multithreading._8_manipulation._4.fork.join.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Long> {
    private final long workload;

    public MyRecursiveTask(long workload) {
        this.workload = workload;
    }

    @Override
    protected Long compute() {
        /** if work is above threshold , break task up into smaller tasks */
        if (workload > 5) {
            System.out.println("RecursiveAction: Splitting the task with workload : "
                    + workload + ". " + Thread.currentThread().getName());
            List<RecursiveTask<Long>> subTasks = new ArrayList<>(createSubTasks());
            for (RecursiveTask subTask : subTasks) {
                subTask.fork();
            }
            long result = 0;
            for (RecursiveTask<Long> subTask : subTasks){
                result += subTask.join();
            }
            return result;
        }else {
            System.out.println("RecursiveAction: Doing the task with workload : "
                    + workload + ". " + Thread.currentThread().getName());
            return workload * 2;
        }
    }
    private List<RecursiveTask<Long>> createSubTasks() {
        List<RecursiveTask<Long>> subTasks = new ArrayList<>();
        RecursiveTask<Long> first = new MyRecursiveTask(workload / 2);
        RecursiveTask<Long> second = new MyRecursiveTask(workload / 2);
        subTasks.add(first);
        subTasks.add(second);
        return subTasks;
    }
}
