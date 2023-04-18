package multithreading._6.interupt;

import java.util.Random;

public class MyThread extends Thread   {
    @Override
    public void run() {
        int count = 0;
        while (true){
            boolean someProcess = new Random().nextBoolean();
            count++;
            if (someProcess){
                Thread.yield();
                System.out.println("someProcess");
            }
            System.out.println("executed a thread " + count);
            if (isInterrupted()){
                System.out.println("isInterrupted() " + isInterrupted());
                System.out.println("Thread.interrupted() " + Thread.interrupted());
                System.out.println("isInterrupted() " + isInterrupted());
                break;
            }
        }
    }
}
class Main{
    public static void main(String[] args) throws InterruptedException {
        Thread loop = new MyThread();
        loop.start();
        Thread.sleep(10);
        loop.interrupt();
    }
}
