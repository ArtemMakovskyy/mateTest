package main.java8.streamPractice;

import java.util.List;
import java.util.stream.Collectors;

/*
Implement a method getCarModels()
that accepts a list of cars cars
and returns a list of car models
manufactured after 1955.
 */
public class CarModels {
    public static List<String> getCarModels(List<Car> cars) {
        List<String> collect = cars.stream()
                .filter(c -> c.getYear() > 1955)
                .map(car -> car.getModel())
                .collect(Collectors.toList());
        return collect;
    }
}
