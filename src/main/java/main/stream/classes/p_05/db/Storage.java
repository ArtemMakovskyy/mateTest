package main.stream.classes.p_05.db;

import main.stream.classes.p_05.Engine;
import main.stream.classes.p_05.Truck;
import main.stream.classes.p_05.Wheel;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static List<Truck> getTrucks() {
        List<Wheel> t100Wheels = new ArrayList<>();
        t100Wheels.add(new Wheel("Hankook", 43));
        t100Wheels.add(new Wheel("Hankook", 43));
        t100Wheels.add(new Wheel("Continental", 43));
        t100Wheels.add(new Wheel("Continental", 43));
        Truck t100 = new Truck("T100", new Engine("Engine 1", 4000), t100Wheels);

        List<Wheel> t150Wheels = new ArrayList<>();
        t150Wheels.add(new Wheel("Bridgestone", 44));
        t150Wheels.add(new Wheel("Bridgestone", 44));
        t150Wheels.add(new Wheel("Bridgestone", 44));
        t150Wheels.add(new Wheel("Bridgestone", 44));
        Truck t150 = new Truck("T150", new Engine("Engine 1", 4500), t150Wheels);

        List<Wheel> k18Wheels = new ArrayList<>();
        k18Wheels.add(new Wheel("Hankook", 40));
        k18Wheels.add(new Wheel("Hankook", 40));
        k18Wheels.add(new Wheel("Hankook", 40));
        k18Wheels.add(new Wheel("Hankook", 40));
        Truck k18 = new Truck("k18", new Engine("Engine 2", 4500), k18Wheels);

        List<Wheel> m99Wheels = new ArrayList<>();
        m99Wheels.add(new Wheel("Continental", 40));
        m99Wheels.add(new Wheel("Continental", 40));
        m99Wheels.add(new Wheel("Continental", 40));
        m99Wheels.add(new Wheel("Continental", 40));
        Truck m99 = new Truck("k18", new Engine("Engine 3", 4500), m99Wheels);

        return List.of(t100, t150, k18, m99);
    }
}
