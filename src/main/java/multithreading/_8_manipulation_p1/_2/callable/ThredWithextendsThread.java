package multithreading._8_manipulation_p1._2.callable;

public class ThredWithextendsThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
