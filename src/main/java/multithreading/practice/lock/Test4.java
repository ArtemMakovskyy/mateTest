package multithreading.practice.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test4 {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();
        // Поток производителя
        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    buffer.produce(i);
                    Thread.sleep(250); // Пауза для наглядности
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Поток потребителя
        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    buffer.consume();
                    Thread.sleep(1000); // Пауза для наглядности
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}

class SharedBuffer {
    private final Lock lock = new ReentrantLock();
    private final Condition bufferNotEmpty = lock.newCondition();
    private int data;
    private boolean bufferIsFull = false;

    public void produce(int value) throws InterruptedException {
        lock.lock();
        try {
            while (bufferIsFull) {
                bufferNotEmpty.await(); // Ждем, пока буфер не опустеет
            }
            data = value;
            bufferIsFull = true;
            System.out.println("Produced: " + value);
            bufferNotEmpty.signal(); // Сообщаем, что буфер заполнен
        } finally {
            lock.unlock();
        }
    }

    public int consume() throws InterruptedException {
        lock.lock();
        try {
            while (!bufferIsFull) {
                bufferNotEmpty.await(); // Ждем, пока буфер не заполнится
            }
            int consumedData = data;
            bufferIsFull = false;
            System.out.println("Consumed: " + consumedData);
            bufferNotEmpty.signal(); // Сообщаем, что буфер опустел
            return consumedData;
        } finally {
            lock.unlock();
        }
    }
}