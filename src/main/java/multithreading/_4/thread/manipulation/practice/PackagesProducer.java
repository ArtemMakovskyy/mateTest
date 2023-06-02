package multithreading._4.thread.manipulation.practice;

import java.util.List;

public class PackagesProducer implements Runnable{
    private List<String> packages;
    private PackagesService packagesService;
    private Thread thread;

    public PackagesProducer(List<String> packages, PackagesService packagesService, boolean autoStart) {
        this.packages = packages;
        this.packagesService = packagesService;
        if (autoStart) {
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        for (String msg : packages) {
            packagesService.getPackage(msg);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("run: " + msg);
        }
    }
}
