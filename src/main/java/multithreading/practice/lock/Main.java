package multithreading.practice.lock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        first();
        second();
    }

    static void second() throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(counter.getCount());
    }

    static void first() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        WorkerThread workerThread1 = new WorkerThread();
        WorkerThread workerThread2 = new WorkerThread();

        Thread t1 = new Thread(workerThread1);
        Thread t2 = new Thread(workerThread2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("main th is donu");
    }
}

class Counter {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private int count;

    public void increment() {
        synchronized (lock1){
            ++count;
        }

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

class WorkerThread implements Runnable {

    @Override
    public void run() {
        System.out.println("WorkerThread is running");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("WorkerThread is complete");
    }
}