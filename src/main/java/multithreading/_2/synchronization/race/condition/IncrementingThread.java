package multithreading._2.synchronization.race.condition;

public class IncrementingThread implements Runnable {
    private Counter counter;

    public IncrementingThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getValue() < 100) {
            counter.incrementValue();
        }
    }
}
