package multithreading.practice.lock.dead;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

public class DeadlockDetectorExample {
    public static void main(String[] args) {
        // Создаем два объекта-ресурса
        final Object resource1 = new Object();
        final Object resource2 = new Object();

        // Создаем первый поток, который пытается захватить первый ресурс, а затем второй
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Locked resource 1");

                try {
                    // Добавим небольшую задержку, чтобы увеличить шансы на мертвую блокировку
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource2) {
                    System.out.println("Thread 1: Locked resource 2");
                }
            }
        });

        // Создаем второй поток, который пытается захватить второй ресурс, а затем первый
        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Locked resource 2");

                try {
                    // Добавим небольшую задержку, чтобы увеличить шансы на мертвую блокировку
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource1) {
                    System.out.println("Thread 2: Locked resource 1");
                }
            }
        });

        // Запускаем оба потока
        thread1.start();
        thread2.start();

        // Ждем, пока оба потока завершатся
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Обнаружение мертвой блокировки
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        if (deadlockedThreads != null) {
            System.out.println("Deadlocked threads: " + Arrays.toString(deadlockedThreads));
        } else {
            System.out.println("No deadlocked threads found.");
        }
    }
}