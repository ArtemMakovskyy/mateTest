package multithreading.practice.lock.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest2 {
}
 class MyThread extends Thread {
    private Semaphore semaphore;
    private String name;

    public MyThread(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    public void run() {
        try {
            semaphore.acquire();
            System.out.println(name + " acquired the access");
            // some logic that should be available only to N threads at the same time
            System.out.println(name + " is going to release the access");
            semaphore.release();
        } catch (InterruptedException e) {
            System.out.println("Something went wrong for " + name);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        new MyThread(semaphore, "First").start();
        new MyThread(semaphore, "Second").start();
        new MyThread(semaphore, "Third").start();
        new MyThread(semaphore, "Fourth").start();
        new MyThread(semaphore, "Fifth").start();
    }
}