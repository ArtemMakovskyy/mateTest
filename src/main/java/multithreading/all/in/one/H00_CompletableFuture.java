package multithreading.all.in.one;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

//Supplier: Provides results.
//Predicate: Evaluates conditions.
//Function: Transforms data.
//Consumer: Consumes data for operations like printing.
public class H00_CompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        a();
        b();
        c();

    }

    private static void a() {
        //Consumer: Consumes data for operations like printing.
        create()
                .thenAccept(data -> System.out.println(data)) //Runnable dont give any data
                .thenRun(() -> System.out.println("This never dies"));

        create()
                .thenApply(data -> data.toUpperCase())
                .thenAccept(System.out::println);
    }

    private static void b() throws InterruptedException, ExecutionException {
        System.out.println("before cf");
        if (false) {
            System.out.println(create().get());
        } else {
            create().thenAccept(data -> System.out.println(data));
            Thread.sleep(1200);
        }

        System.out.println("after cf");
    }

    private static void c() throws InterruptedException, ExecutionException {
        System.out.println("before cf");
        System.out.println(create().getNow("Olala"));
        System.out.println("after cf");
    }

    private static CompletableFuture<String> create() {
//        CompletableFuture<String> future
//                = CompletableFuture.supplyAsync(() -> "Hello mates!");
//        return future;
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello mates!";
        });
    }
}
