package multithreading.all.in.one;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
public class H02_CompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        a();
        b();
//        c();

    }

    private static void a() {
        create()
                .thenApply(data -> data * 2)
                .thenAccept(data -> System.out.println(data))
                .exceptionally(throwable -> handleException(throwable));
    }
    private static void b() {
        create()
                .exceptionally(throwable -> handleExceptionInteger(throwable))
                .thenApply(data -> data * 2)
                .thenAccept(data -> System.out.println(data));

    }
    private static Void handleException(Throwable throwable) {
        System.out.println(throwable);
        return null;
    }

    private static Integer handleExceptionInteger(Throwable throwable) {
        System.out.println(throwable);
        return -1;
    }

    private static CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(() -> compute());
    }

    private static int compute() {
        if (System.currentTimeMillis() % 2 == 0) {
            throw new RuntimeException("Exception from compute()");
        }
        return 2;
    }
}
