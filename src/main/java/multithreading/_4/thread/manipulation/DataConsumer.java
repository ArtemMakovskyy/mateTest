package multithreading._4.thread.manipulation;

import java.util.ArrayList;
import java.util.List;

public class DataConsumer implements Runnable{
    private DataService dataService;
    private String finalPackage;
    private List<String>packages = new ArrayList<>();
    private Thread thread;

    public DataConsumer(DataService dataService, String finalPackage) {
        this.dataService = dataService;
        this.finalPackage = finalPackage;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        String currentPackage;
        do{
            currentPackage = dataService.receiveData();
            packages.add(currentPackage);
        }while (!currentPackage.equals(finalPackage));
        System.out.println(packages);
    }
}
