package multithreading._9_cuncurrent.part2._3.synzer;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class Main_CyclicBarrier {
    public static void main(String args[]) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new BarAction());

        System.out.println("Запуск потоков");

        new MyThread(cyclicBarrier, "A");
        new MyThread(cyclicBarrier, "B");
        new MyThread(cyclicBarrier, "C");
        new MyThread(cyclicBarrier, "D");
        new MyThread(cyclicBarrier, "E");
        new MyThread(cyclicBarrier, "F");
        new MyThread(cyclicBarrier, "G");

    }
}

class MyThread implements Runnable {
    CyclicBarrier cyclicBarrier;
    String name;

    MyThread(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
        new Thread(this).start();
    }

    public void run() {
        System.out.println(name + " " + Thread.currentThread().getName());
        try {
            cyclicBarrier.await(1L, TimeUnit.SECONDS);
//            cyclicBarrier.await();
        } catch (BrokenBarrierException | InterruptedException exc) {
            System.out.println(exc);
        } catch (TimeoutException e) {
            throw new RuntimeException("Time is gone", e);
        }
    }
}

class BarAction implements Runnable {
    public void run() {
        System.out.println("Барьер достигнут " + Thread.currentThread().getName());
    }
}