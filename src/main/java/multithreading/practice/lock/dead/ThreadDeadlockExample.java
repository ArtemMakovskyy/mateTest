package multithreading.practice.lock.dead;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class ThreadDeadlockExample {
    public static void main(String[] args) {
        final Object resource1 = new Object();
        final Object resource2 = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Поток 1: заблокировал ресурс 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println("Поток 1: заблокировал ресурс 2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Поток 2: заблокировал ресурс 2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource1) {
                    System.out.println("Поток 2: заблокировал ресурс 1");
                }
            }
        });

        thread1.start();
        thread2.start();

        // Обнаружение дедлока с использованием ThreadMXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        if (deadlockedThreads != null) {
            System.out.println("Заблокированные потоки:");
            for (long threadId : deadlockedThreads) {
                System.out.println("Идентификатор потока: " + threadId);
            }
        } else {
            System.out.println("Заблокированные потоки не найдены.");
        }
    }
}