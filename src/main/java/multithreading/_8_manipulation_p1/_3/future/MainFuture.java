package multithreading._8_manipulation_p1._3.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainFuture {
    public static void main(String[] args) {
        four();
    }

    static void four() throws RuntimeException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable<String> callableTask = new CallableTask();
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(callableTask));
        }
        executorService.shutdown();
        for (Future<String> future : futures)
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("some", e);
            }
    }
}

class CallableTask implements Callable<String> {
    static volatile int counter = 0;
    @Override
    public String call() throws Exception {
        Thread.sleep(100);
        System.out.println("Task is technically competed: "
                + Thread.currentThread().getName() + " "
                + Thread.currentThread().hashCode());
        counter ++;
        return "Hello world " + counter;
//        throw new Exception("cast exception");
    }
}