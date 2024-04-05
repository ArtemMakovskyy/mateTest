package multithreading.all.in.one;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class C00_ExecutorService_Future {
    private static final int THREADS_POOL = 5;
    private static final int THREADS = 20;

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_POOL);
        Callable<String> myThread = new MyCallableThread();
        for (int i = 0; i < THREADS; i++) {
            Future<String> future = executorService.submit(myThread);
            futures.add(future);
        }
        executorService.shutdown();
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Can't get data from future ",e);
            }
        }
    }
}


class MyCallableThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int duration = (new Random().nextInt(4) + 1) * 100;
        Thread.sleep(duration);
        return "Task duration was " + duration + " ms, execution finished at " + LocalTime.now();
    }
}
