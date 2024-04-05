package multithreading.practice.lock.semaphore;

import java.util.concurrent.Semaphore;
/**
 * Попытка забронировать место для пользователя.
 *
 * @param user имя пользователя
 * @return результат бронирования
 */
public class Philosopher implements Runnable {
    private final Semaphore semaphore;

    public Philosopher(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaphore.acquire();
                doAction("Preparing to eat ... ");
                doAction("... eating ... ");
                doAction("Finale thoughts about a food");
                semaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void doAction(String action) {
        System.out.printf("%s %s%n", Thread.currentThread().getName(), action);
        try {
            Thread.sleep((int) Math.random() * 100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

class ThinkingPhilosophers {
    private static final int NUM_PHILOSOPHERS = 5;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            Runnable philosopher = new Philosopher(semaphore);
            Thread thread = new Thread(philosopher, "Philosopher " + (i + 1));
            thread.start();
        }
    }
}
