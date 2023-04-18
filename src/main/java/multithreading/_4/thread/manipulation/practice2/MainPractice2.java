package multithreading._4.thread.manipulation.practice2;

import java.util.ArrayList;
import java.util.List;

public class MainPractice2 {
    public static void main(String[] args) {
        String finalPackage = "end";
        List<String> dataList = List.of("A", "B", "C", "D", finalPackage);
        ServiceTransmitter serviceTransmitter = new ServiceTransmitter();
//        synchronized (){
            new SenderThread(dataList, serviceTransmitter);
            new GetPackage(serviceTransmitter,finalPackage);
//        }
    }
}
