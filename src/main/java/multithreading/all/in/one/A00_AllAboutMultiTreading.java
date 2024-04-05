package multithreading.all.in.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class A00_AllAboutMultiTreading {
    public static void main(String[] args) throws InterruptedException {
//        createThreadWithThread();
//        createThreadWithThreadWithUnonimClass();
//        createThreadWithImplRunnable();
//        createThreadRunnableWithExecutor();
//        createThreadCallableWithExecutor();
        createThreadCallableWithExecutorTaskSum();
    }

    private static void createThreadWithThread() {
        ThreadCreation threadCreation = new ThreadCreation();
        threadCreation.start();
        try {
            threadCreation.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("<--------------->");
    }

    private static void createThreadWithThreadWithUnonimClass() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Create Thread with anonim class");
            try {
                Thread.sleep(100);
                Thread.currentThread().setName("createThreadWithThreadWithUnknownClass");
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });
        thread.start();
        thread.join();
        System.out.println("<--------------->");
    }

    private static void createThreadWithImplRunnable() {
        RunnableThread runnableThread = new RunnableThread();
        Thread runnable = new Thread(runnableThread);
        runnable.start();
        try {
            runnable.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("<--------------->");
    }

    private static void createThreadRunnableWithExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new RunnableThread());
        final Future<?> submit = executorService.submit(new RunnableThread());

        try {
            System.out.println(submit.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        System.out.println("<--------------->");
    }

    private static void createThreadCallableWithExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        final MyCallableStringLength callable = new MyCallableStringLength("Hello");
        for (int i = 0; i < 5; i++) {
            executorService.submit(callable);
        }
        System.out.println("<--------------->");
        executorService.shutdown();
    }

    private static void createThreadCallableWithExecutorTaskSum() {
        Random random = new Random();
        int length = 5000;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            numbers.add(random.nextInt());
        }
        int start = 0;
        int first = numbers.size() / 4;
        int second = numbers.size() / 4 * 2;
        int third = numbers.size() / 4 * 3;
        int end = numbers.size();
        List<Integer> one = new ArrayList<>(numbers.subList(start, first));
        List<Integer> two = new ArrayList<>(numbers.subList(first, second));
        List<Integer> three = new ArrayList<>(numbers.subList(second, third));
        List<Integer> four = new ArrayList<>(numbers.subList(third, end));
        List<List<Integer>> tasks = List.of(one, two, three, four);

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Callable<Integer>> callables = new ArrayList<>();

        for (List<Integer> task : tasks) {
            callables.add(new MyCallableCalculateSum(task));
        }

        try {
            List<Future<Integer>> futures = executorService.invokeAll(callables);
            for (Future<Integer> future : futures) {
                Integer result = future.get();
                System.out.println("Sum: " + result);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}

class ThreadCreation extends Thread {
    @Override
    public void run() {
        System.out.println("Creation extends Thread");
        try {
            Thread.sleep(100);
            Thread.currentThread().setName("createThreadWithThread");
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Creation implements Runnable");
        try {
            Thread.sleep(100);
            Thread.currentThread().setName("CreationImplementsRunnable");
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}

class MyCallableStringLength implements Callable<Integer> {
    private final String value;

    public MyCallableStringLength(String value) {
        this.value = value;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(100);
        System.out.println(value + " " + Thread.currentThread().getName());
        return value.length();
    }
}

class MyCallableCalculateSum implements Callable<Integer> {
    private List<Integer> integers;

    public MyCallableCalculateSum(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public Integer call() throws Exception {
        return integers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}