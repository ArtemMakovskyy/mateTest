package multithreading.all.in.one;


import java.util.LinkedList;
import java.util.Queue;

public class F00_BlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new BlockingQueue<>(10);
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();
    }
}

class BlockingQueue<T> {
    private Queue<T> queue = new LinkedList<>();
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(T element) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(element);
        notify();
    }

    public synchronized T take() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        notify();
        return queue.poll();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}

class Producer implements Runnable {
    private BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                blockingQueue.put(i);
            } catch (InterruptedException e) {
                throw new RuntimeException("Producer was interrupted!", e);
            }
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (!blockingQueue.isEmpty()) {
            try {
                System.out.println("Took value " + blockingQueue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException("Consumer was interrupted!", e);
            }
        }
    }
}
