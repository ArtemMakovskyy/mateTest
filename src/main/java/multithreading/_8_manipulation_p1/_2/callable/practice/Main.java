package multithreading._8_manipulation_p1._2.callable.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable<Integer>task = new ForEachTask();
        List<Future<Integer>>futures = new ArrayList<>();
        int  sum = 0;
        for (int i = 0; i < 200; i++) {
            Future<Integer> submit = executorService.submit(task);
            futures.add(submit);
            sum += submit.get();
        }
        int  sum2 = 0;
        executorService.shutdown();
        System.out.println("sum " + sum);
        for (Future<Integer> future : futures) {
            sum2 += future.get();
        }
        System.out.println(sum);
        System.out.println(sum2);
    }
}
