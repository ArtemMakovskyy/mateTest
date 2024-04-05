package multithreading.practice.lock.semaphore;

public class PhilosopherDL implements Runnable {
    private Object leftFork;
    private Object rightFork;

    public PhilosopherDL(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        while (true) {
            doAction("Thinking");
            synchronized (leftFork) {
                doAction("Picked up left fork");
                synchronized (rightFork) {
                    doAction("Picked up right fork, and start eating ...");
                    doAction("Put down right fork");
                }
                doAction("Put down left fork. Back to thinking action");
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

class ThinkingPhilosophers2 {
    private static final int NUM_PHILOSOPHERS = 5;

    public static void main(String[] args) {

        final PhilosopherDL[] philosopherDLS = new PhilosopherDL[NUM_PHILOSOPHERS];
        final Object[] forks = new Object[NUM_PHILOSOPHERS];

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % NUM_PHILOSOPHERS];
            philosopherDLS[i] = new PhilosopherDL(leftFork, rightFork);
            Thread thread = new Thread(philosopherDLS[i], "Philosopher " + (i + 1));
            thread.start();
        }
    }
}