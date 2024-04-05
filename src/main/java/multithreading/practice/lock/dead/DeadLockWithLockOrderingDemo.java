package multithreading.practice.lock.dead;

public class DeadLockWithLockOrderingDemo {
    private static final String res1 = "abc";
    private static final String res2 = "bcd";

    public static void main(String[] args) {
        boolean isDeadlock = true;
        Thread t1 = new Thread(() -> {
            String firstLock = (res1.compareTo(res2) >= 0) ? res1 : res2;
            String secondLock = (res1.compareTo(res2) >= 0) ? res2 : res1;
            synchronized (firstLock) {
                System.out.println("Thread 1 locked res 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                if (isDeadlock) {
                    synchronized (secondLock) {
                        System.out.println("Thread 1 locked res 2");
                    }
                }

            }
        });
        Thread t2 = new Thread(() -> {
            String firstLock = (res1.compareTo(res2) >= 0) ? res1 : res2;
            String secondLock = (res1.compareTo(res2) >= 0) ? res2 : res1;
            synchronized (firstLock) {
                System.out.println("Thread 2 locked res 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                if (isDeadlock) {
                    synchronized (secondLock) {
                        System.out.println("Thread 2 locked res 1");
                    }
                }

            }
        });

        t1.start();
        t2.start();
    }
}
