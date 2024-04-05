package multithreading.practice.lock;

import lombok.Getter;
import lombok.Setter;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Counter2 counter2 = new Counter2();
        Thread thread1 = new Thread(new StartCount(counter2));
        Thread thread2 = new Thread(new StartCount(counter2));

        Thread thread3 = new Thread(new StartCount2(counter2));
        Thread thread4 = new Thread(new StartCount2(counter2));

        thread1.start();
        thread2.start();

        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread4.join();
        thread3.join();
        System.out.println(counter2.getValue());
        System.out.println(counter2.getValue2());
    }
}

class StartCount2 implements Runnable {

    private Counter2 counter2;

    public StartCount2(Counter2 counter2) {
        this.counter2 = counter2;
    }

    @Override
    public void run() {
        System.out.println("in");
        for (int i = 0; i < 100000000; i++) {
            counter2.increment2();
        }
        System.out.println("out");
    }
}

class StartCount implements Runnable {

    private Counter2 counter2;

    public StartCount(Counter2 counter2) {
        this.counter2 = counter2;
    }

    @Override
    public void run() {
        System.out.println("in");
        for (int i = 0; i < 100000000; i++) {
            counter2.increment();
        }
        System.out.println("out");
    }
}

@Getter
@Setter
class Counter2 {
    private int value;
    private int value2;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void increment() {
        synchronized (lock1) {
            value++;
        }
    }

    public void increment2() {
        synchronized (lock2) {
            value2++;
        }
    }
}
