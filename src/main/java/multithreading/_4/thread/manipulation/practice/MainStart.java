package multithreading._4.thread.manipulation.practice;

import java.util.List;

public class MainStart {
    public static void main(String[] args) {
        String finalPackage = "-";
        List<String> packages = List.of("A", "b", "c", "d", "e", "f", "g", "h", "i", finalPackage);
        PackagesService packagesService = new PackagesService();

        new PackagesProducer(packages, packagesService);
        new PackagesConsumer(packagesService, finalPackage);
    }
}
