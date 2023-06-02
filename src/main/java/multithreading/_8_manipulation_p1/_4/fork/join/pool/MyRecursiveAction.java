package multithreading._8_manipulation_p1._4.fork.join.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {
    private final long workload;

    public MyRecursiveAction(long workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        /** if work is above threshold , break task up into smaller tasks */
        if (workload > 5) {
            System.out.println("RecursiveAction: Splitting the task with workload : "
                    + workload + ". " + Thread.currentThread().getName());
            List<RecursiveAction> subTasks = new ArrayList<>(createSubTasks());
            for (RecursiveAction subTask : subTasks) {
                subTask.fork();
            }
        }else {
            System.out.println("RecursiveAction: >>> Doing the task with workload : "
                    + workload + ". " + Thread.currentThread().getName());
        }
    }

    private List<RecursiveAction> createSubTasks() {
        List<RecursiveAction> subTasks = new ArrayList<>();
        RecursiveAction first = new MyRecursiveAction(workload / 2);
        RecursiveAction second = new MyRecursiveAction(workload / 2);
        subTasks.add(first);
        subTasks.add(second);
        return subTasks;
    }
}
