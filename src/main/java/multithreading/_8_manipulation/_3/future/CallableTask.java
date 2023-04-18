package multithreading._8_manipulation._3.future;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(100);
        System.out.println("Task is technically competed: "
                + Thread.currentThread().getName() + " "
                + Thread.currentThread().hashCode());
//        return "Hello world";
        throw new Exception("cast exception");
    }
}
