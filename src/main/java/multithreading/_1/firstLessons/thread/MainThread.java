package multithreading._1.firstLessons.thread;

public class MainThread {
    public static void main(String[] args) {
//        createThreadsWithTwoWaysAndRealisationDaemon();
        createThreadLocal();
    }
    static void createThreadsWithTwoWaysAndRealisationDaemon(){
        Thread currentThread = Thread.currentThread();

        System.out.println("Program started");
        System.out.println(currentThread);

        Thread myThread = new MyThread();
        myThread.setDaemon(true);
        myThread.start();

        Runnable myRunnable = new MyRunnable();
        Thread myRunnableThread = new Thread(myRunnable);
        myRunnableThread.start();
    }
    static void createThreadLocal(){
        Thread firstThread = new MyThread();
        Thread secondThread = new MyThread();
        firstThread.start();
        secondThread.start();
    }
}
