package multithreading._8_manipulation._3.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        four();
    }

    static void four() throws RuntimeException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable<String> task = new CallableTask();
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            futures.add(executorService.submit(task));
        }
        executorService.shutdown();
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("some", e);
            }
        }
    }


}
