package multithreading._2.synchronization.deadLiveLock;

public class Philosopher implements Runnable{
    private final Object leftFork;
    private final Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        while (true){
            try {
                doAction("Thinking");
                synchronized (leftFork){
                    doAction("Pick up left fork");
                    synchronized (rightFork){
                        doAction("Pick up right fork - eating");
                        doAction("Put down right fork");
                    }
                    doAction("Put down left fork. Back to thinking");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " " + action);
        Thread.sleep((int)(Math.random()*100));
    }
}
