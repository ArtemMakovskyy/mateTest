package multithreading._9_cuncurrent.part2._3.synzer;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main_CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Waiter waiter = new Waiter(latch);
        Cook firstCook = new Cook(latch);
        Cook secondCook = new Cook(latch);
        Cook thirdCook = new Cook(latch);
//        Cook fourthCook = new Cook(latch);
//        Cook five = new Cook(latch);
//        Cook six = new Cook(latch);
//        Cook seven = new Cook(latch);

    }
}

class Waiter implements Runnable {
    private CountDownLatch countDownLatch;

    public Waiter(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        new Thread(this).start();
    }

    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException("Something went wrong!", e);
        }
        System.out.println("All dishes were prepared");
    }
}

class Cook implements Runnable {
    private CountDownLatch countDownLatch;

    public Cook(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        new Thread(this).start();
    }

    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Cook is preparing the dish");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException("Something went wrong!", e);
        }
    }
}