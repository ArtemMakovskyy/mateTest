package multithreading._4.thread.manipulation.practice2;

public class ServiceTransmitter {
    private String packageMsg;
    private boolean flag;

    public synchronized void put(String msg) {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        packageMsg = msg;
        System.out.print("put:  " + packageMsg);
        flag = false;
        notify();
    }

    public String passerPackage() {
        synchronized (this){
//            System.out.println(this);
            while (flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            flag = true;
            notify();
            System.out.println(" pass: " + packageMsg);
            return packageMsg;
        }

    }
}
