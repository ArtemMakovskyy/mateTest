package multithreading.practice;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread first = new MyThread("first");
        first.join();
        MyThread second = new MyThread("second");
        second.join();
//            first.start();
//            second.start();
        System.out.println("massage in main thread");
    }
}
