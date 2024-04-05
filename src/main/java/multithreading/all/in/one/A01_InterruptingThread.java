package multithreading.all.in.one;

public class A01_InterruptingThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("START " + System.currentTimeMillis());
        InfiniteLoopThread thread1 = new InfiniteLoopThread();
        InfiniteLoopThread thread2 = new InfiniteLoopThread();
        thread1.start();
        thread2.start();
        Thread.sleep(1500);
        thread1.interrupt();
        Thread.sleep(1000);
        thread2.interrupt();
        thread1.join();
        thread2.join();
        System.out.println("END " + System.currentTimeMillis());
    }
}

class InfiniteLoopThread extends Thread {
    private int ciclesNumber;

    public void run() {
        try {
            while (!Thread.interrupted()) { // Вечный цикл, пока поток не будет прерван
                ciclesNumber++;
                System.out.println("Этот цикл продолжается... Цикл "
                        + ciclesNumber + " "
                        + Thread.currentThread().getName());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван.");
        }
    }
}