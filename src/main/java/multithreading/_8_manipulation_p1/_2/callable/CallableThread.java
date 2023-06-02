package multithreading._8_manipulation_p1._2.callable;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("Task is technically competed: "
                + Thread.currentThread().getName() + " "
                + Thread.currentThread().hashCode());
        return "Hello world";
    }
}
