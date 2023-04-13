package multithreading._1.firstLessons.thread;

import java.util.Random;

public class MyThread extends Thread{
//    private static Integer number = null;
    private static ThreadLocal<Integer> number = new ThreadLocal<>();
    @Override
    public void run() {
//        number = new Random().nextInt(100);
        number.set(new Random().nextInt(100));
//        System.out.println("Logic inside MyThread thread " + Thread.currentThread().getName());
        for (int i = 0; i < 3; i++) {
            System.out.println(String.format("Thread %s is running. Value is %d",
//                    Thread.currentThread().getName(),number));
                    Thread.currentThread().getName(),number.get()));
        }
    }
}
