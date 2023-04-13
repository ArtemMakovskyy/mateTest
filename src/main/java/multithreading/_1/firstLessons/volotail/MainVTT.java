package multithreading._1.firstLessons.volotail;

public class MainVTT {
    public static void main(String[] args) throws InterruptedException {
        VolatileTestingThread thread = new VolatileTestingThread();
        thread.start();
        Thread.sleep(1000);
        System.out.println("After sleeping in main thread");
        thread.setKeepRunning(false);
    }
}
