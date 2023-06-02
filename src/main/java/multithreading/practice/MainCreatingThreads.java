package multithreading.practice;

import multithreading._8_manipulation_p1._2.callable.RunnableThread;

import java.util.concurrent.Executor;

public class MainCreatingThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new MyThread();
        myThread.setName("EXTENDS THREAD");
        myThread.start();
        myThread.join();

        Thread myThread2 = new MyThreadStartWithConstructor("Thread start with constructor");

        Runnable runnableThread = new MyRunnableThread();
        Thread simpleThreadWitRunnable = new Thread(runnableThread);
        simpleThreadWitRunnable.setName("implements runnable");
        simpleThreadWitRunnable.start();

        Thread myRunnableThreadWithConstructor =
                new Thread(new MyRunnableThreadWithConstructor("implements runnable and constructor"));

        Executor myExecutor = new MyExecutor();
        myExecutor.execute(()-> System.out.println("This an implementation of run() method of Runnable"));
        myExecutor.execute(runnableThread);


    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Create simple thread: " + Thread.currentThread().getName());
    }
}

class MyThreadStartWithConstructor extends Thread {
    String name;

    public MyThreadStartWithConstructor(String name) throws InterruptedException {
        super(name);
        start();
        this.join();
    }

    @Override
    public void run() {
        System.out.println("Create simple thread: " + Thread.currentThread().getName());
    }
}

class MyRunnableThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Create simple thread: " + Thread.currentThread().getName());
    }
}

class MyRunnableThreadWithConstructor implements Runnable {
    Thread thread;

    public MyRunnableThreadWithConstructor(String name) throws InterruptedException {
        thread = new Thread(this);
        thread.setName(name);
        thread.start();
        thread.join();
    }

    @Override
    public void run() {
        System.out.println("Create simple thread: " + Thread.currentThread().getName());
    }
}

class MyExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}

