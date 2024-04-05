package multithreading.practice.lock;

public class Test {
    private static final Object lock = new Object();
    private static volatile boolean isDoing = false;

    public static void main(String[] args) throws InterruptedException {
        // начинаем процесс сообщение
        // длительный процесс
        // по завершению сообщение делаем дальше
        final long start = System.currentTimeMillis();
        System.out.println("1 Start process at: " + (System.currentTimeMillis() - start));

        Thread hardWorkProcessThread = new Thread(() -> {
            try {
                System.out.println("3 before Thread.sleep(2000);");
                Thread.sleep(10);
                System.out.println("5 after Thread.sleep(2000);");
                synchronized (lock) {

                    System.out.println("6 Into synchronized (lock) >>> insert hardWorkProcessThread.start() " + (System.currentTimeMillis() - start));
                    isDoing = true;
                    System.out.println("7 after isDoing = true & before  lock.notify()" + (System.currentTimeMillis() - start));
                    lock.notify();
                    System.out.println("8 after lock.notify()" + (System.currentTimeMillis() - start));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        hardWorkProcessThread.start();

        synchronized (lock) {
            System.out.println("2 synchronized (lock) { before while" + (System.currentTimeMillis() - start));
            while (!isDoing){
                System.out.println("4 before lock.wait()..."  + (System.currentTimeMillis() - start));
                lock.wait();
                System.out.println("9 after lock.wait()..."  + (System.currentTimeMillis() - start));
                System.out.println("10 Finish  process at: " + (System.currentTimeMillis() - start));
            }
        }
    }
}
