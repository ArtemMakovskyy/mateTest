package multithreading.shildt.call;

class CallMe2 {
    synchronized public void go(String msg) {
        System.out.print("[");
        try {
            Thread.sleep(10);
            System.out.print(msg);
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("]\n");
    }
}

class SynchronizerCall implements Runnable {
    String msg;
    CallMe2 callMe2;

    public SynchronizerCall(String msg, CallMe2 callMe2) {
        this.msg = msg;
        this.callMe2 = callMe2;
    }

    @Override
    public void run() {
        callMe2.go(msg);
    }
}

class Main {
    public static void main(String[] args) {
        CallMe2 callMe2 = new CallMe2();
        Runnable second = new SynchronizerCall("In the", callMe2);
        Runnable third = new SynchronizerCall("synh world", callMe2);
        Runnable first = new SynchronizerCall("Well come", callMe2);
        Thread t1 = new Thread(first);
        Thread t2 = new Thread(second);
        Thread t3 = new Thread(third);

        try {
            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}