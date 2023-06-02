package multithreading.practice;

import multithreading._1.firstLessons.thread.MyRunnable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutors {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService es1 = Executors.newSingleThreadExecutor();
//        es1.submit(new MyRunnableThread());
//        es1.shutdown();

        ExecutorService es2 = Executors.newFixedThreadPool(2);
        System.out.println(es2.submit(new MyCallable()).get() + " with get ");
        es2.submit(new MyRunnable());
        es2.submit(new MyRunnableThreadWithConstructor("some name"));
        es2.shutdown();

    }
}
class MyCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return 1;
    }
}
