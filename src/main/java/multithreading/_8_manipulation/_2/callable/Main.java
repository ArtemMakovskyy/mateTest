package multithreading._8_manipulation._2.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//        one();
//        two_1();
//        two_2();
        three();
    }

    static void one() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            executorService.submit(new CallableThread());
        }
        executorService.shutdown();
    }

    static void two_1() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            executorService.submit(new CallableThread());
        }
        executorService.shutdown();
    }

    static void two_2() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> task = new CallableThread();
        for (int i = 0; i < 20; i++) {
            executorService.submit(task);
        }
        executorService.shutdown();
    }

    static void three() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable<String> task = new CallableThread();
        for (int i = 0; i < 20; i++) {
            executorService.submit(task);
        }
        executorService.shutdown();
    }

    static void oldMethods() {
        Thread thread1 = new ThredWithextendsThread();
        Thread thread2 = new Thread(new RunnableThread());
        thread1.setName("thread");
        thread2.setName("runnable");

        thread1.start();
        thread2.start();
    }
}
