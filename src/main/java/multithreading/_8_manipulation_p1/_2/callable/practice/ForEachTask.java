package multithreading._8_manipulation_p1._2.callable.practice;

import java.util.Random;
import java.util.concurrent.Callable;

public class ForEachTask implements Callable<Integer> {
    private static volatile int numberThread;
    static {
        numberThread++;
    }

    @Override
    public Integer call() throws Exception {
        int bound = 20;
        ctreate_number();
        int length = new Random().nextInt(bound);
        int counter = length;
        for (int i = 0; i < length; i++) {
            Thread.yield();
            counter += new Random().nextInt(length);
            if (length < bound/20)
                System.out.println("sleep");
                Thread.sleep(0,bound);
        }
        System.out.println("number is" + getNumber() + " >> length is " + length + ", counter "
                + counter + " ----- " + Thread.currentThread().getName());
        return counter;
    }

    private synchronized void ctreate_number() {
        numberThread++;
    }

    private static synchronized int getNumber() {
        return numberThread;
    }
}
