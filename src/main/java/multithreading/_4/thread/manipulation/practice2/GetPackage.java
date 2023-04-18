package multithreading._4.thread.manipulation.practice2;

import java.util.ArrayList;
import java.util.List;

public class GetPackage implements Runnable {
    List<String> dataList;
    ServiceTransmitter serviceTransmitter;
    String finalPackage;
    Thread thread;

    public GetPackage(ServiceTransmitter serviceTransmitter, String finalPackage) {
        this.serviceTransmitter = serviceTransmitter;
        this.finalPackage = finalPackage;
        dataList = new ArrayList<>();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        String msg;
        do {
//            synchronized (){
                msg = serviceTransmitter.passerPackage();
//            }
            dataList.add(msg);
        } while (!finalPackage.equals(msg));
        System.out.println(dataList);
    }
}
