package main.clone.practice3;

import main.immutable.Info;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FirstClass fc1 = new FirstClass(1,2);
        FirstClass fc2;
        fc2 = fc1.clone();
        fc2.setI(3);
        FirstClass fc3 = new FirstClass();
        fc3.setI(fc1.getI());
        fc3.setS(fc1.getS());
//        fc3 =fc1;
        fc3.setI(8);
        System.out.println(fc1);
        System.out.println(fc2);
        System.out.println(fc3);

        FourthWithCollection fwc1 = new FourthWithCollection();
        fwc1.setString("first with collection 1");
        fwc1.setIntegerList(List.of(1,2,3));
        FourthWithCollection fwc2 = fwc1.clone();
        fwc2.setIntegerList(List.of(11,22,33));
//
        System.out.println(fwc1);
        System.out.println(fwc2);


    }
}
