package multithreading._4.thread.manipulation.practice;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainStart {
    public static void main(String[] args) {
        String finalPackage = "-";
        List<String> packages = List.of("A", "b", "c", "d", "e", "f", "g", "h", "i", finalPackage);
        ExecutorService es = Executors.newCachedThreadPool();
        PackagesService packagesService = new PackagesService();
        es.submit(new PackagesProducer(packages, packagesService, false));
        es.submit(new PackagesConsumer(packagesService, finalPackage, false));
        es.shutdown();
    }
}
