package multithreading.practice;

public class MyThread extends Thread {
    private String name;
    public Thread thread;

    public MyThread(String name) {
        this.name = name;
        thread = new Thread(this,name);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " is done");
    }
}
