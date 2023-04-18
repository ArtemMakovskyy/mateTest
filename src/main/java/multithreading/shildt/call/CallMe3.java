package multithreading.shildt.call;

public class CallMe3 {
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

class Synchker implements Runnable {
    CallMe3 callMe;
    String msg;
    Thread t;

    public Synchker(CallMe3 callMe, String msg) {
        this.callMe = callMe;
        this.msg = msg;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        callMe.go(msg);
    }
}


class MainStarter {
    public static void main(String[] args) {
        String[] msgs = new String[]{"Welcome", "to the", "synch world"};
        CallMe3 callMe3 = new CallMe3();
        for (int i = 0; i < msgs.length; i++) {
            new Synchker(callMe3, msgs[i]);
        }
    }
}
