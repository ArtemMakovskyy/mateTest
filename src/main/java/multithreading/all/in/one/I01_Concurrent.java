package multithreading.all.in.one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class I01_Concurrent {
    static Object lock1 = new Object();
    static Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        aSynchronized();
//        aWaitNotify();
//        aCountDownLatch();
//        aCallable();
        aCompletableFuture();
//        b();
//        cBlockedQueue();
//        dConcurrentLinkedQueue();
    }

    static void dConcurrentLinkedQueue() throws InterruptedException {
    }

    static void aSynchronized() throws InterruptedException {
        final long l = System.currentTimeMillis();
        List<Integer> integers = new ArrayList<>();
        Thread t1;
        Thread t2;
        Thread t3;

        t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock1) {
                    integers.add(i);
                }
            }
        });

        t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock1) {
                    integers.add(i);
                }
            }
        });

        t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock1) {
                    integers.add(i);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(integers.size() + " " + (System.currentTimeMillis() - l));
    }

    static void aWaitNotify() throws InterruptedException {
        final long l = System.currentTimeMillis();
        List<Integer> integers = new ArrayList<>();
        Thread t1;
        Thread t2;
        Thread t3;

        // Создаем объект монитора для синхронизации доступа к списку и флаг для сигнализации
        Object monitor = new Object();
        AtomicBoolean isFinished = new AtomicBoolean(false);

        t1 = new Thread(() -> {
            synchronized (monitor) {
                for (int i = 0; i < 1000; i++) {
                    integers.add(i);
                }
                // Оповещаем другие потоки о завершении работы
                isFinished.set(true);
                monitor.notifyAll();
            }
        });

        t2 = new Thread(() -> {
            synchronized (monitor) {
                // Ждем, пока первый поток не завершится
                while (!isFinished.get()) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < 1000; i++) {
                    integers.add(i);
                }
                // Оповещаем о завершении работы
                isFinished.set(true);
                monitor.notifyAll();
            }
        });

        t3 = new Thread(() -> {
            synchronized (monitor) {
                // Ждем, пока первый поток не завершится
                while (!isFinished.get()) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < 1000; i++) {
                    integers.add(i);
                }
                // Оповещаем о завершении работы
                isFinished.set(true);
                monitor.notifyAll();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(integers.size() + " " + (System.currentTimeMillis() - l));
    }

    static void aCountDownLatch() throws InterruptedException {
        final long l = System.currentTimeMillis();
        List<Integer> integers = new ArrayList<>();
        Thread t1;
        Thread t2;
        Thread t3;

        // Создаем объект CountDownLatch с одним счетчиком, равным количеству потоков
        CountDownLatch latch = new CountDownLatch(3);

        t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                integers.add(i);
            }
            // Уменьшаем счетчик CountDownLatch
            latch.countDown();
        });

        t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                integers.add(i);
            }
            // Уменьшаем счетчик CountDownLatch
            latch.countDown();
        });

        t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                integers.add(i);
            }
            // Уменьшаем счетчик CountDownLatch
            latch.countDown();
        });

        t1.start();
        t2.start();
        t3.start();

        // Ждем, пока все потоки завершат свою работу
        latch.await();

        System.out.println(integers.size() + " " + (System.currentTimeMillis() - l));
    }

    static void aCallable() throws InterruptedException, ExecutionException {
        final long l = System.currentTimeMillis();
        List<Integer> integers = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<Void>> tasks = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            tasks.add(() -> {
                for (int i = 0; i < 10000; i++) {
                    integers.add(i);
                }
                return null;
            });
        }

        List<Future<Void>> futures = executor.invokeAll(tasks);

        // Ждем завершения всех задач
        for (Future<Void> future : futures) {
            future.get(); // Дожидаемся завершения
        }

        executor.shutdown();
        System.out.println(integers.size() + " " + (System.currentTimeMillis() - l));
    }

    static void aCompletableFuture() throws InterruptedException, ExecutionException {
        final long l = System.currentTimeMillis();
        List<Integer> integers = new CopyOnWriteArrayList<>();

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 1000; i++) {
                integers.add(i);
                if (i % 250 == 0) {
                    System.out.println((System.currentTimeMillis() - l) + " " + Thread.currentThread().getName() + " inserted " + i);
                }
            }
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 1000; i++) {
                integers.add(i);
                if (i % 250 == 0) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println((System.currentTimeMillis() - l) + " " + Thread.currentThread().getName() + " inserted " + i);
                }
            }
        });

        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 1000; i++) {
                integers.add(i);
                if (i % 250 == 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println((System.currentTimeMillis() - l) + " " + Thread.currentThread().getName() + " inserted " + i);
                }
            }
        });

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

        combinedFuture.get();
        System.out.println(integers.size() + " " + (System.currentTimeMillis() - l));
    }
}

