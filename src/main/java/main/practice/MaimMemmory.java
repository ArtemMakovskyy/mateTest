package main.practice;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaimMemmory {
    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        runIt();
//        runtime.runFinalization();
        runFori();
        runIt();
                runtime.gc();
                Thread.sleep(100);
        runIt();
    }

    static void runIt() {
        Runtime runtime = Runtime.getRuntime();
//        System.out.println("availableProcessors " + runtime.availableProcessors());
        System.out.println("freeMemory " + runtime.freeMemory());
//        System.out.println("maxMemory " + runtime.maxMemory());
//        System.out.println("totalMemory " + runtime.totalMemory());
    }

    static void runFori() {
        System.out.println("start");
        List<Date> list = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            list.add(new Date());
        }
    }
}
