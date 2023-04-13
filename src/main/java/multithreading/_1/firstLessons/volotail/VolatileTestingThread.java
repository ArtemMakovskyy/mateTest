package multithreading._1.firstLessons.volotail;

public class VolatileTestingThread extends Thread{
    private volatile boolean keepRunning = true;

    public void setKeepRunning(boolean keepRunning) {
        this.keepRunning = keepRunning;
    }

    @Override
    public void run() {
        long count = 0;
        while (keepRunning){
            count++;
        }
        System.out.println("Thread terminated, count is " + count);
    }
}
