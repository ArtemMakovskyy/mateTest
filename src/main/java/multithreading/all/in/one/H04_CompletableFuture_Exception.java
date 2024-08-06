package multithreading.all.in.one;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class H04_CompletableFuture_Exception {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        a();
//        b();
//        c();
//        d();
//        e();
//        f();
        g();
    }

    static void sleep100() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void a() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            // Делаем какое-то действие
            return 10;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            // Делаем другое действие
            return 20;
        });

        CompletableFuture<Integer> combinedFuture = future1.thenCombine(future2, (result1, result2) -> result1 + result2);

        combinedFuture.thenAccept(result -> System.out.println("Результат: " + result));
    }

    static void b() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // Делаем какое-то действие, которое может вызвать исключение
            if (Math.random() > 0.5) {
                throw new RuntimeException("Ошибка в вычислении");
            }
            return 42;
        });

        future.exceptionally(ex -> {
            System.out.println("Произошло исключение: " + ex.getMessage());
            return -1; // Заменяем результат на -1 в случае исключения
        });

        future.thenAccept(result -> System.out.println("Результат: " + result));

    }

    static void c() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            // Делаем какое-то действие
            System.out.println("Выполняется future1");
            if (Math.random() > 0.5) {
                System.out.println("Ошибка в future1");
                throw new RuntimeException("Ошибка в future1");
            }
            return 10;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            // Делаем другое действие
            System.out.println("Выполняется future2");
            return 20;
        });

        CompletableFuture<Integer> combinedFuture = future1.thenCombine(future2, (result1, result2) -> {
            System.out.println("Выполняется операция с результатами future1 и future2");
            return result1 + result2;
        });

        combinedFuture.thenAccept(result -> {
            System.out.println("Результат: " + result);
            System.out.println("Выполняется действие после получения результата combinedFuture");
        });

        // Добавим обработку исключения для future1
        future1.exceptionally(ex -> {
            System.out.println("Произошло исключение в future1: " + ex.getMessage());
            return -1; // Заменяем результат на -1 в случае исключения
        });

        // Добавим еще одну операцию then после return в future1
        future1.thenApply(result -> {
            System.out.println("Действие после return в future1: " + result);
            return result * 2;
        });

        // Добавим еще одну операцию then после return в future2
        future2.thenApply(result -> {
            System.out.println("Действие после return в future2: " + result);
            return result * 2;
        });
    }

    static void d() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // Некоторая логика, которая может вызвать исключение
            // Например, деление на ноль
            System.out.println("int result = 10 / 0;");
            int result = 10 / 5; // Возникнет ArithmeticException
            return result;
        });

        // Обработка исключения и продолжение выполнения с альтернативной логикой
        CompletableFuture<Integer> alternativeFuture = future.exceptionally(ex -> {
            System.out.println("Исключение произошло: " + ex);
            // Выполнение альтернативной логики
            return 0; // Возвращаем значение по умолчанию
        });

        // Продолжение выполнения с альтернативной логикой
        alternativeFuture.thenAccept(result -> System.out.println("Результат с альтернативной логикой: " + result));
    }
    static void e(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("WTF!");
            }
            return "Success";
        });
        String result = future.exceptionally(ex -> "Recovered").join();
        System.out.println(result);
    }
    static void f(){
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> System.out.println("Zadanie 1"));
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> System.out.println("Zadanie 2"));
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);

        combinedFuture.join();
    }
    static void g(){
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Zadanie asynchroniczne");
        }).thenRun(() -> {
            throw new RuntimeException("Oj! Coś poszło nie tak!");
        });

        future.join();
    }
}
