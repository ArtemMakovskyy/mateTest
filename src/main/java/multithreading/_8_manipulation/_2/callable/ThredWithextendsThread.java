package multithreading._8_manipulation._2.callable;

public class ThredWithextendsThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
