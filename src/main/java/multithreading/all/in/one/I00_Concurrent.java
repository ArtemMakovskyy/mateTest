package multithreading.all.in.one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class I00_Concurrent {
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        a();
//        b();
//        cBlockedQueue();
//        dConcurrentLinkedQueue();
    }

    static void dConcurrentLinkedQueue() throws InterruptedException {
        AtomicBoolean producerFinished
                = new AtomicBoolean(false);
        final ConcurrentLinkedQueue<String> queue
                = new ConcurrentLinkedQueue();
        final boolean interrupted = false;
        Thread producerWriteData = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                queue.offer("Message " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
              producerFinished.set(true);
        });


        Thread consumerReadData = new Thread(() -> {
            while (!producerFinished.get() || !queue.isEmpty()) {
                // Consumer waits if queue is empty
                while (!producerFinished.get() && queue.isEmpty()) {
                    try {
                        Thread.sleep(150); // Sleep briefly to avoid busy waiting
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // Consume data
                String message = queue.poll();
                if (message != null) {
                    System.out.println("Consumed " + message);
                }
            }
        });

        producerWriteData.start();
        consumerReadData.start();
        producerWriteData.join();
        consumerReadData.join();
    }

    static void cBlockedQueue() throws InterruptedException {
        final ArrayBlockingQueue<String> queue
                = new ArrayBlockingQueue(10);
        Thread producerWriteData = new Thread(() -> {
            try {
                queue.put("Hello");
                Thread.sleep(1000);
                queue.put(" Mates!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread consumerReadData = new Thread(() -> {
            try {
                System.out.print(queue.take());
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        producerWriteData.start();
        consumerReadData.start();
        producerWriteData.join();
        consumerReadData.join();
    }

    static void b() throws InterruptedException {
        final long l = System.currentTimeMillis();
        List<Integer> integers = new CopyOnWriteArrayList<>();

        Thread t1;
        Thread t2;

        t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                integers.add(i);
            }
        });


        t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                integers.add(i);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(integers.size() + " " + (System.currentTimeMillis() - l));
    }

    static void a() throws InterruptedException {
        final long l = System.currentTimeMillis();
        List<Integer> integers = new ArrayList<>();
        Thread t1;
        Thread t2;
        Thread t3;

            t1 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    synchronized (lock1){
                        integers.add(i);
                    }
                }
            });

            t2 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    synchronized (lock1){
                        integers.add(i);
                    }
                }
            });

            t3 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    synchronized (lock1){
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
}
