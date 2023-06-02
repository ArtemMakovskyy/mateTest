package multithreading._9_cuncurrent.part2.tregulov;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;

public class ConcurrentHashMapExample {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>(Map
                .of(1, "Zaur", 2, "Oleg", 3, "Sergey", 4, "Ivan", 5, "Igor"));

        Runnable runnable = () -> {
            Iterator<Integer> integerIterator = map.keySet().iterator();
            while (integerIterator.hasNext()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Integer next = integerIterator.next();
                System.out.println(next + " : " + map.get(next));
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                map.put(6, "Elena");
                map.put(7, "Artem");
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(runnable);
        executorService.submit(runnable2);
        executorService.shutdown();

//        Thread thread = new Thread(runnable);
//        Thread thread2 = new Thread(runnable2);
//        thread.start();
//        thread2.start();
//        thread.join();
//        thread2.join();
        System.out.println(map);
    }
}
