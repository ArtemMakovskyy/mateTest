package multithreading._9_cuncurrent.part2._4atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class MAinAtomic {
    public static void main(String[] args) {

    }
}

class BeforeSafeCounter {
    private volatile int counter;

    public synchronized void setCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}

class AfterSafeCounter {
    private final AtomicInteger counter = new AtomicInteger(0);

    public int getCounter() {
        return counter.get();
    }
    public int increment(){
        return counter.getAndIncrement();
    }
}