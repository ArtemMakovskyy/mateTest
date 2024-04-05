package multithreading.practice.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockMAin {
    public static void main(String[] args) {

    }
}

class SharedResource {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void read() {
        readWriteLock.readLock().lock();
        try {
            // Perform read operations
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void write() {
        readWriteLock.writeLock().lock();
        try {
            // Perform write operations
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}