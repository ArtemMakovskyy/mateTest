package multithreading._4.thread.manipulation.practice3;

import java.util.List;

public class PackageProducer implements Runnable {
    PackageService packageService;
    List<String> packages;

    public PackageProducer(PackageService packageService, List<String> packages) {
        this.packageService = packageService;
        this.packages = packages;
    }

    @Override
    public void run() {
        for (String currentPackage : packages) {
            packageService.save(currentPackage);
        }
    }
}
