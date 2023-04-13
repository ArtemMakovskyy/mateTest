package multithreading._1.firstLessons;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());
        System.out.println(currentThread.getPriority());
        currentThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println(currentThread.getPriority());
    }
}
