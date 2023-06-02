package multithreading._9_cuncurrent.part2._5.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteList <T>{
    private List<T>list = new ArrayList<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private void add(T element){
        Lock writeLock = readWriteLock.writeLock();
        writeLock.lock();
        try {
            list.add(element);
        }finally {
            writeLock.unlock();
        }
    }
}
