package multithreading.practice.lock;

public class Test2 {
    private static Test2 lock = new Test2();
    private static volatile boolean isFinished = false;

    public static void main(String[] args) throws InterruptedException {

        Thread task2secThread = new Thread(() -> {
            try {
                synchronized (lock) {
                    System.out.println("Into task2secThread");
                    Thread.sleep(2000);
                    System.out.println("finished hard task into thread");
                    lock.notify();
                    isFinished = true;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        task2secThread.start();
        synchronized (lock) {
            while (!isFinished){
                lock.wait();
                System.out.println("End of task!!!");
//                isFinished = false;
            }
        }
    }
}
