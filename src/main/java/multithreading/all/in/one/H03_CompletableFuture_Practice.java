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

public class H03_CompletableFuture_Practice {
    private static String value = "String value";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
String s = "prn s";
//        final CompletableFuture<String> future = CompletableFuture.supplyAsync(
//                () -> "Hello" + "o"
//        );
//        future.thenApply(data -> data.toUpperCase() + " ...aa".toUpperCase())
//        .thenAccept(data -> {
//            System.out.println(data);
//            System.out.println(s);
//        }).thenRun(()-> System.out.println("still work"));

        final CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->{
//            sleep100();
            return "Hello";
        });
        System.out.println(".............");
        future2.thenApply(data -> data.toUpperCase())
                .thenAccept(data -> {
                    System.out.println(data);
                    System.out.println(s);
                }).thenRun(()-> System.out.println("still work"));

//        a();
//        b();
    }

    static void sleep100(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    static void b() {
        UserService userService = new UserService();
        try {
            final User user = userService.findUserById(1L).get();
            System.out.println(user);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static void a() throws ExecutionException, InterruptedException {
        /**
         * CompletableFuture.supplyAsync(): Асинхронно выполняет заданную функцию, создавая
         * CompletableFuture, который будет завершен с результатом выполнения функции.
         */
        final CompletableFuture<String> future = CompletableFuture.completedFuture(value);
        final CompletableFuture<String> future1 = CompletableFuture.completedFuture(
                value.length() > 50
                        ? "length value less more 50, and is " + value
                        : "length value less then 50 and is: " + value + " " + value.length());

        /**
         * CompletableFuture.supplyAsync(): Асинхронно выполняет заданную функцию, создавая
         * CompletableFuture, который будет завершен с результатом выполнения функции.
         */
        final CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "result");

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            return "result";
        });

        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                final int length = value.length();
                return "Result: Value is: " + value + ", and length is: " + length;
            }
        });

        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            final int length = value.length();
            return "Result: Value is: " + value + ", and length is: " + length;
        }, Executors.newSingleThreadExecutor());

        /**
         * CompletableFuture.completedStage(): Создает завершенный CompletableFuture,
         * который является сценой (stage). Сцена - это объект, представляющий
         * последовательность шагов, которые должны быть выполнены асинхронно
         */
        final CompletionStage<String> stage = CompletableFuture.completedStage("stage");

        /**
         * CompletableFuture.failedFuture(): Создает завершенный CompletableFuture,
         * который завершается с исключением, указанным в качестве аргумента.
         */
        CompletableFuture<String> failedFuture = CompletableFuture.failedFuture(new RuntimeException("error"));

        /**
         * CompletableFuture.allOf(): Принимает массив CompletableFuture и возвращает
         * новый CompletableFuture, который завершается, когда все переданные CompletableFuture завершаются.
         */
        CompletableFuture.allOf();
        CompletableFuture<String> future11 = CompletableFuture.supplyAsync(() -> "result1");
        CompletableFuture<String> future12 = CompletableFuture.supplyAsync(() -> "result2");
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future11, future12);

        /**
         * CompletableFuture.anyOf(): Принимает массив CompletableFuture и возвращает новый CompletableFuture,
         * который завершается, когда хотя бы один из переданных CompletableFuture завершается.
         */
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(future11, future12);

        /**
         * CompletableFuture.delayedExecutor(): Возвращает исполнитель (executor),
         * который выполняет задачи с указанной задержкой.
         */
        Executor delayedExecutor = CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS);

        /**
         * CompletableFuture.runAsync(): Асинхронно выполняет заданное действие,
         * которое не возвращает результат.
         */
        CompletableFuture<Void> future6 = CompletableFuture.runAsync(() -> {
            System.out.println("Do some void method");
        });
    }
}


class UserService {
    private UserRepository userRepository = new UserRepository();

    private Map<Long, User> cache = new ConcurrentHashMap<>();

    public CompletableFuture<User> findUserById(Long userId) {
        // Асинхронно ищем пользователя сначала в кэше
        CompletableFuture<User> cacheLookup = CompletableFuture.supplyAsync(() -> cache.get(userId));

        // Если пользователь найден в кэше, возвращаем результат
        cacheLookup.thenApply(user -> {
            if (user != null) {
                return user;
            } else {
                // Если пользователя нет в кэше, ищем в базе данных
                return userRepository.findById(userId);
            }
        });
        return cacheLookup;
    }
}

class User {
    private String userName;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}

class UserRepository {
    private static Map<Long, User> repository = new ConcurrentHashMap<>();

    static {
        repository.put(1L, new User("Ivan1"));
        repository.put(2L, new User("Ivan2"));
        repository.put(3L, new User("Ivan3"));
        repository.put(4L, new User("Ivan4"));
        repository.put(5L, new User("Ivan5"));
        repository.put(6L, new User("Ivan6"));
    }

    public User findById(Long id) {
        return repository.get(id);
    }
}