package multithreading.shildt.call;

public class Callme {
    synchronized void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    Callme target;
    Thread t;

    public Caller(String msg, Callme target) {
        this.msg = msg;
        this.target = target;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        target.call(msg);
    }
}

class Synch {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller("Well come", target);
        Caller ob2 = new Caller("in synchronizing", target);
        Caller ob3 = new Caller("world", target);


//        try {
//            ob1.t.join();
//            ob2.t.join();
//            ob3.t.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException("Interrupt ", e);
//        }

    }
}