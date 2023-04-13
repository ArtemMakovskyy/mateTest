package multithreading._2.synchronization.race.condition;

public class MainCounter {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable runnable = new IncrementingThread(counter);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(runnable,"Thread: " + (i+ 1));
            thread.start();
        }
    }
}
