package multithreading._4.thread.manipulation.practice2;

import java.util.List;

public class SenderThread implements Runnable{
    List<String> dataList;
    ServiceTransmitter serviceTransmitter;
    Thread thread;

    public SenderThread(List<String> dataList, ServiceTransmitter serviceTransmitter) {
        this.dataList = dataList;
        this.serviceTransmitter = serviceTransmitter;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (String s : dataList) {
            try {
                serviceTransmitter.put(s);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
