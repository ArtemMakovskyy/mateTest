package multithreading.shildt.threads;

public class SecondTestThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.printf("%s thread, number %d \n",Thread.currentThread().getName(),i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
