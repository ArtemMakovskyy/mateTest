package multithreading._9_cuncurrent.part2._2.blocking.queues;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer>ebq = new ArrayBlockingQueue<>(10);
        BlockingQueue<Object> objects = new LinkedBlockingQueue<>();
        BlockingQueue<Integer>pbq = new PriorityBlockingQueue<>();
//        BlockingQueue<Object>dq = new DelayQueue<>();
        BlockingQueue<Integer>sq = new SynchronousQueue<>();
    }
}
