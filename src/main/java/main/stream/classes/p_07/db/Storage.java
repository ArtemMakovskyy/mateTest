package main.stream.classes.p_07.db;

import main.collection.pecs.A;
import main.stream.classes.p_07.model.Advertisment;
import main.stream.classes.p_07.model.Car;
import main.stream.classes.p_07.model.User;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static List<Advertisment> getAdvertisment() {
        List<Advertisment> advertismentList = new ArrayList<>();
        User bob = new User("Bob", "+5445645");
        User alice = new User("Alice", "+456546456");
        User john = new User("Jonh", "+3805054654645655447");

        Advertisment camry = new Advertisment(bob, new Car("Toyota", "Camry", 2011));
        Advertisment coroppa = new Advertisment(bob, new Car("Toyota", "Corolla", 2018));
        Advertisment yaris = new Advertisment(bob, new Car("Toyota", "Yaris", 2020));
        Advertisment accord = new Advertisment(alice, new Car("Honda", "Accord", 2018));
        Advertisment matiz = new Advertisment(john, new Car("Deawo", "Matiz", 2008));
        Advertisment lanos = new Advertisment(john, new Car("Deawo", "Lanos", 2017));
        advertismentList.add(camry);
        advertismentList.add(coroppa);
        advertismentList.add(yaris);
        advertismentList.add(matiz);
        advertismentList.add(lanos);
        advertismentList.add(accord);
        return advertismentList;
    }
}
