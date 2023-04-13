package main.pecs.practice.srorage;

import main.pecs.practice.model.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {
   public static Storage getStorage(){
      return new Storage();
   }
   public  List<Zeppelin> zeppelins() {
      Zeppelin big = new Zeppelin("Zeppelin", "BIG", 50, 400);
      Zeppelin small = new Zeppelin("Zeppelin", "SMALL", 50, 10);
      return List.of(big, small);
   }

   public  List<Helicopter> helicopters() {
      Helicopter attack = new Helicopter("Helicopter", "Attack", 440, 5);
      Helicopter apache = new Helicopter("Helicopter", "Apache", 333, 6);
      Helicopter mi24 = new Helicopter("Helicopter", "Mi-24", 420, 4);
      return List.of(apache, attack, mi24);

   }

   public  List<CargoPlain> cargoPlains() {
      CargoPlain mriya = new CargoPlain("Cargo plain", "An-225 Mriya", 800, 2);
      CargoPlain boeing747_8F = new CargoPlain("Cargo plain", "Boeing 747-8F", 700, 4);
      return List.of(boeing747_8F, mriya);
   }

   public  List<PassengersPlain> passengersPlains() {
      PassengersPlain boeing = new PassengersPlain("Passenger plain", "Boeing 777-200", 500, 440);
      PassengersPlain airbus = new PassengersPlain("Passenger plain", "Airbus A380-800", 800, 853);
      return List.of(boeing, airbus);
   }
}
