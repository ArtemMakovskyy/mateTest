package multithreading._9_cuncurrent.part2._3.synzer;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainSynchronizers {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        firstSemaphore();
        secondCountDownLatch();
    }
    static void firstSemaphore() throws InterruptedException {
        Semaphore semaphore1 = new Semaphore(5);
        Semaphore semaphore2 = new Semaphore(5,true);
        semaphore1.acquire();
        semaphore2.tryAcquire();
        System.out.println("so code");
        semaphore1.release();
        semaphore2.release();

    }
    static void secondCountDownLatch() throws BrokenBarrierException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        CyclicBarrier cb = new CyclicBarrier(2);
        cb.await();

    }
}
