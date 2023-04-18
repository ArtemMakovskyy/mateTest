package multithreading._4.thread.manipulation.practice;

public class PackagesService {
    private String dataPackage;
    private boolean gate = true;

    public synchronized void getPackage(String msg){
        while (!gate){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        dataPackage = msg;
        gate = false;
        System.out.print("get data: " + msg);
        notify();
    }

    public synchronized String sendPackage(){
        while (gate){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        gate = true;
        System.out.println(">> send data " + dataPackage);
        notify();
        return dataPackage;
    }
}
