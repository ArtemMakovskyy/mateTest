package multithreading.all.in.one;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class E00_ReentrantReadWriteLock {
    public static void main(String[] args) {
        ReadWriteList<Integer> list = new ReadWriteList<>();

        Writer writer = new Writer(list);
        Reader reader = new Reader(list);

        for (int i = 0; i < 5; i++) {
            new Thread(writer).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(reader).start();
        }
    }
}

class ReadWriteList<E> {
    private List<E> list = new ArrayList<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void add(E element) {
        lock.writeLock().lock();
        try {
            list.add(element);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public E get(int index) {
        lock.readLock().lock();
        try {
            return list.get(index);
        } finally {
            lock.readLock().unlock();
        }
    }

    public int size() {
        lock.readLock().lock();
        try {
            return list.size();
        } finally {
            lock.readLock().unlock();
        }
    }
}

class Reader implements Runnable {
    private ReadWriteList<Integer> sharedList;

    public Reader(ReadWriteList<Integer> sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        Random random = new Random();
        int size = sharedList.size();
        if (size > 0) {
            Integer number = sharedList.get(random.nextInt(size));
            System.out.println(Thread.currentThread().getName() + " -> read: " + number);
        }
    }
}

class Writer implements Runnable {
    private ReadWriteList<Integer> sharedList;

    public Writer(ReadWriteList<Integer> sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        int number = new Random().nextInt(100);
        sharedList.add(number);
        System.out.println(Thread.currentThread().getName() + " -> write: " + number);
    }
}
