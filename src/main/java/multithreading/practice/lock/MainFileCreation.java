package multithreading.practice.lock;

import java.io.File;
import java.io.IOException;

public class MainFileCreation {
    private static final String FILE_PATH = "file.txt";
    private static final Object lock = new Object();
    private static volatile boolean isFileCreated = false;

    public static void main(String[] args) throws InterruptedException {
        Thread fileCreatorThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                synchronized (lock) {
                    final File file = new File(FILE_PATH);
                    if (file.createNewFile()) {
                        System.out.println("file created by background thread.");
                        isFileCreated = true;
                        lock.notify();
                    }
                }
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        fileCreatorThread.start();

        synchronized (lock){
            while (!isFileCreated){
                lock.wait();
                System.out.println("The main method is waiting");
            }
        }

        new File(FILE_PATH).delete();
        System.out.println("File deleted");
    }
}

