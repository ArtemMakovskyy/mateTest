package multithreading._1.firstLessons.thread;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Logic inside MyRunnable thread " + Thread.currentThread().getName());
    }
}
