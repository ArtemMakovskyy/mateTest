package main.collection;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.*;

public class EnumSetMapMain {
    public static void main(String[] args) {
        String link = "https://www.youtube.com/watch?v=bMQv71w_qWY";
        enumMap();
        enumSet();
    }

    private static void enumMap() {
        List<Car> minivanCars = new ArrayList<>();
        minivanCars.add(new Car("Toyota"));
        minivanCars.add(new Car("BMW"));

        List<Car> sportCars = new ArrayList<>();
        sportCars.add(new Car("Lexus"));
        sportCars.add(new Car("Audi"));

        EnumMap<CarType, List<Car>> enumMapCars
                = new EnumMap<CarType, List<Car>>(CarType.class);

        enumMapCars.put(CarType.MINIVAN, minivanCars);
        enumMapCars.put(CarType.SPORT, sportCars);

        System.out.println(enumMapCars.get(CarType.SPORT));

        iterateMap(enumMapCars);

    }

    private static void enumSet() {
        EnumSet<WeekDay> holidays
                = EnumSet.of(WeekDay.Saturday, WeekDay.Sunday);

        EnumSet<WeekDay> workingDays
                = EnumSet.of(WeekDay.Monday, WeekDay.Tuesday,
                WeekDay.Wednesday,WeekDay.Thursday,WeekDay.Friday);

        System.out.println();
        System.out.println(holidays);
        System.out.println(workingDays);

    }

    private static void iterateMap(Map map) {
        System.out.println();
        Iterator<Map.Entry<CarType, Car>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<CarType, Car> carEntry = iterator.next();
            System.out.println(carEntry.getKey() + " - " + carEntry.getValue());
        }
    }
}

@AllArgsConstructor
@ToString
class Car {
    private String model;
}

enum CarType {
    CROSSOVER,
    MINIVAN,
    SPORT;
}

enum WeekDay {
    Sunday,
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday
}

//enum WeekDay2 {
//
//    private boolean holiday;
//
//    WeekDay2(boolean holiday) {
//        this.holiday = holiday;
//    }
//
//    Sunday(true),
//
//    Monday(false),
//
//    Tuesday(false),
//
//    Wednesday(false),
//
//    Thursday(false),
//
//    Friday(false),
//
//    Saturday(true)
//}
