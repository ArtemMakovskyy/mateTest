package multithreading.practice.lock.dead;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockWithTryLockDemo {
    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                if (lock1.tryLock(100, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println("Thread 1 locked res 1");
                        Thread.sleep(100);

                        if (lock2.tryLock(100, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println("Thread 1 locked res 2");
                            } finally {
                                lock2.unlock();
                            }
                        } else {
                            System.out.println("Mistakes lock2");
                        }
                    } finally {
                        lock1.unlock();
                    }
                } else {
                    System.out.println("Mistakes lock1");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                if (lock2.tryLock(100, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println("Thread 2 locked res 2");
                        Thread.sleep(100);

                        if (lock1.tryLock(100, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println("Thread 2 locked res 1");
                            } finally {
                                lock1.unlock();
                            }
                        } else {
                            System.out.println("Mistakes lock1");
                        }
                    } finally {
                        lock2.unlock();
                    }
                } else {
                    System.out.println("Mistakes lock2");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }
}
