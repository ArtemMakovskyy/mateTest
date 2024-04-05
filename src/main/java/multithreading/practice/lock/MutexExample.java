package multithreading.practice.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedResourceEx {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // Захватываем мьютекс
        try {
            count++; // Изменяем общий ресурс
            System.out.println("Incremented: " + count);
        } finally {
            lock.unlock(); // Освобождаем мьютекс в блоке finally
        }
    }

    public void decrement() {
        lock.lock(); // Захватываем мьютекс
        try {
            count--; // Изменяем общий ресурс
            System.out.println("Decremented: " + count);
        } finally {
            lock.unlock(); // Освобождаем мьютекс в блоке finally
        }
    }
}

public class MutexExample {
    public static void main(String[] args) {
        SharedResourceEx sharedResource = new SharedResourceEx();

        // Создаем два потока, которые будут одновременно увеличивать и уменьшать значение общего ресурса
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.increment();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.decrement();
            }
        });

        // Запускаем потоки
        incrementThread.start();
        decrementThread.start();

        // Ожидаем завершения потоков
        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}