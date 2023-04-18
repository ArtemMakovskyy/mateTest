package multithreading._4.thread.manipulation.practice;

import java.util.ArrayList;
import java.util.List;

public class PackagesConsumer implements Runnable {
    private PackagesService packagesService;
    private String lastPackage;
    private Thread thread;
    private List<String> packages = new ArrayList<>();

    public PackagesConsumer(PackagesService packagesService, String lastPackage) {
        this.packagesService = packagesService;
        this.lastPackage = lastPackage;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        String msg;
        do {
            msg = packagesService.sendPackage();
            packages.add(msg);
            System.out.println("add " + msg);
        } while (!msg.equals(lastPackage));
        System.out.println(packages);
    }
}
