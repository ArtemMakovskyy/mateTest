package multithreading._9_cuncurrent.part2._1.collections;

import java.util.concurrent.*;

public class MainConcurrentCollectionReview {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> cw = new CopyOnWriteArrayList<>();


        ConcurrentMap<String, Integer> concurrentMap
                = new ConcurrentHashMap<>();
        ConcurrentMap<String, Integer> objectObjectConcurrentSkipListMap
                = new ConcurrentSkipListMap<>();

        ConcurrentLinkedQueue<Integer> integers = new ConcurrentLinkedQueue<>();
        ConcurrentLinkedDeque<Object> objects = new ConcurrentLinkedDeque<>();

    }
}
