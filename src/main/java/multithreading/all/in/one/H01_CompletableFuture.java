package multithreading.all.in.one;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class H01_CompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        a();
//        b();
//        c();

    }

    private static void a() {
        System.out.println("In main " + Thread.currentThread().getName());
        createExeServ().thenAccept(d -> System.out.println(d));
        System.out.println("Main done");
        System.out.println("---------------");
    }

    private static void b() throws InterruptedException, ExecutionException {
        System.out.println("In main " + Thread.currentThread().getName());
        createSleep().thenAccept(d -> System.out.println(d));
        System.out.println("Main done");
        System.out.println("---------------");
    }

    private static void c() throws InterruptedException, ExecutionException {
        System.out.println("In main " + Thread.currentThread().getName());
        create().thenAccept(d -> System.out.println(d));
        System.out.println("Main done");
        System.out.println("---------------");
    }

    private static CompletableFuture<String> create() {
        return CompletableFuture.supplyAsync(() -> "Hello mates!"
                + Thread.currentThread().getName());
    }

    private static CompletableFuture<String> createSleep() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello mates!";
        });
    }

    private static CompletableFuture<String> createExeServ() {
        final ExecutorService executorService
                = Executors.newFixedThreadPool(10);
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello mates!";
        },executorService);
    }
}
