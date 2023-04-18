package multithreading.shildt;

import multithreading.shildt.threads.FirstTestThread;
import multithreading.shildt.threads.SecondTestThread;

public class MainThreads {
    public static void main(String[] args) {
        threads();
    }
    private static void threads(){
        Thread firstTestThread = new FirstTestThread();
//        Thread secondTastThread = new Thread(new SecondTestThread());
        Thread secondTastThread = new FirstTestThread();
        firstTestThread.setName("first");
        secondTastThread.setName("second");
        firstTestThread.setPriority(10);
        firstTestThread.start();
        secondTastThread.start();
        System.out.println(firstTestThread.isAlive());
        try {
            firstTestThread.join();
            secondTastThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
