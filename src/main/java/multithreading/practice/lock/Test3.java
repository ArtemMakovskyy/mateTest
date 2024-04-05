package multithreading.practice.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.Data;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        counterReentrantLock();
        counterObjectLock();
        counterReentrantTryLock();
    }

    static void counterReentrantLock() throws InterruptedException {
        CounterReentrantLock counter = new CounterReentrantLock();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.iterate();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.iterate();
            }
        });
        startAndJoin(thread1, thread2);
        System.out.println(counter.getCount());
    }


    static void counterReentrantTryLock() throws InterruptedException {
        CounterReentrantTryLock counter = new CounterReentrantTryLock();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.iterate();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.iterate();
            }
        });
        startAndJoin(thread1, thread2);
        System.out.println(counter.getCount());
        System.out.println(counter.getNotAcquired());
    }

    static void counterObjectLock() throws InterruptedException {
        CounterObjectLock counter = new CounterObjectLock();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.iterate();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.iterate();
            }
        });
        startAndJoin(thread1, thread2);
        System.out.println(counter.getCount());
    }

    static void startAndJoin(Thread t1, Thread t2) {
        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

@Data
class CounterReentrantTryLock {
    private int count = 0;
    private int notAcquired = 0;
    private Lock lock = new ReentrantLock();

    public void iterate() {
//        lock.lockInterruptibly();
//        lock.newCondition();

        try {
            if (lock.tryLock(100, TimeUnit.NANOSECONDS)) {
    //        if (lock.tryLock()) {
                try {
                    count++;
                } finally {
                    lock.unlock();
                }
            } else {
                notAcquired ++;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

@Data
class CounterReentrantLock {
    private int count = 0;
    private Lock lock = new ReentrantLock(true);

    public void iterate() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}

@Data
class CounterObjectLock {
    private int count = 0;
    private Object lock = new Object();

    public void iterate() {
        synchronized (lock) {
            count++;
        }
    }
}