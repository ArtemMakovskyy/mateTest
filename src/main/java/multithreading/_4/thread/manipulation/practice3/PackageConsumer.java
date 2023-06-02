package multithreading._4.thread.manipulation.practice3;

import java.util.ArrayList;
import java.util.List;

public class PackageConsumer implements Runnable {
    PackageService packageService;
    String finalPackage;
    List<String> packages;

    public PackageConsumer(PackageService packageService, String finalPackage) {
        this.packageService = packageService;
        this.finalPackage = finalPackage;
        packages = new ArrayList<>();
    }

    @Override
    public void run() {
        String receive;
        do {
            receive = packageService.receive();
            packages.add(receive);
        } while (!receive.equals(finalPackage));
        System.out.println(packages);
        System.out.println("task solved");

    }
}
