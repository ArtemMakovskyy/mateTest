package multithreading._4.thread.manipulation;

public class DataProducer implements Runnable{
    private DataService dataService;
    private String[] packages;
    private Thread thread;
    public DataProducer(DataService dataService, String[] packages) {
        this.dataService = dataService;
        this.packages = packages;
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        for (String currentPackage : packages) {
            try {
                dataService.sendData(currentPackage);
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
