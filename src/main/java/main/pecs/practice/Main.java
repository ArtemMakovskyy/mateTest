package main.pecs.practice;

import main.pecs.practice.model.*;
import main.pecs.practice.srorage.Storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static final Storage storage = Storage.getStorage();
    static List<CargoPlain> cargoPlains = storage.cargoPlains();
    static List<Helicopter> helicopters = storage.helicopters();
    static List<PassengersPlain> passengersPlains = storage.passengersPlains();
    static List<Zeppelin> zeppelins = storage.zeppelins();

    public static void main(String[] args) {

        List<? super FlyingVehicle> addFlyingVehicle = addFlyingVehicle();
        showVehicle(addFlyingVehicle);

        List<? super FlyingVehicle> changedList = change(addFlyingVehicle, 25, "NEW");
        showVehicle(changedList);

        List<? super FlyingVehicle>fv =new ArrayList<>(changedList);
        System.out.println(fv.get(1));
        ArrayList<Integer>integers;
        ArrayList<String>strings;
    }

    private static List<? super FlyingVehicle> change(
            List<? super FlyingVehicle> list, int addSpeed, String addMarker) {
        List<? super FlyingVehicle> changedList = new ArrayList<>();
        FlyingVehicle flyingVehicle = null;
        for (int i = 0; i < list.size(); i++) {
            flyingVehicle = (FlyingVehicle) list.get(i);
            flyingVehicle.setSpeed(flyingVehicle.getSpeed() + addSpeed);
            flyingVehicle.setModel(flyingVehicle.getModel() + " " + addMarker + "");
            changedList.add(flyingVehicle);
        }
        flyingVehicle = null;
        return changedList;
    }

    private static List<? super FlyingVehicle> addFlyingVehicle() {
        List<? super FlyingVehicle> vehicles = new ArrayList<>(cargoPlains);
        vehicles.addAll(storage.cargoPlains());
        vehicles.addAll(storage.helicopters());
        vehicles.addAll(storage.passengersPlains());
        vehicles.addAll(storage.zeppelins());
        return vehicles;
    }


    private static void showVehicle(List<? super FlyingVehicle> list) {
        for (Object o : list) System.out.println(((FlyingVehicle) o).showTechnicalDescription());
        System.out.println();
    }
}
