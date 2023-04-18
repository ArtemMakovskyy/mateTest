package multithreading._4.thread.manipulation;

public class DataService {
    String currentPackage;
    private boolean transfer = true;

    public synchronized void sendData(String currentPackage) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.currentPackage = currentPackage;
        System.out.print("   Sending data:" + currentPackage + " >>> ");
        transfer = false;
        notify();
    }

    public synchronized String receiveData() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("RECEIVE DATA:" + currentPackage);
        transfer = true;
        notify();
        return currentPackage;
    }
}
