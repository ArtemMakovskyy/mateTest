package main.stream.classes.p_05;

import main.stream.classes.p_05.db.Storage;

public class Main {
    public static void main(String[] args) {
        TruckService truckService = new TruckServiceImpl();
        truckService.getEngineModel(Storage.getTrucks()).forEach(System.out::println);
        truckService.getWheelMakers(Storage.getTrucks()).forEach(System.out::println);
    }
}
