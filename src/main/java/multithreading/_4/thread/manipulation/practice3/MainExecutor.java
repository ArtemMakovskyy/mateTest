package multithreading._4.thread.manipulation.practice3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutor {
    public static void main(String[] args) {
        String finalPackage = "fp";
        List<String> packages = List.of("A", "B", "C", "D", "E", "F", finalPackage);
        PackageService packageService = new PackageService();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new PackageProducer(packageService,packages));
        executorService.submit(new PackageConsumer(packageService,finalPackage));
        executorService.shutdown();


    }
}
