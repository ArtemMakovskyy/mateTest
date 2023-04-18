package multithreading.shildt.threads;

public class FirstTestThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.printf("%s thread, number %d \n",Thread.currentThread().getName(),i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
