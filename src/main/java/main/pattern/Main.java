package main.pattern;

import main.pattern.builder.Car;
import main.pattern.of.User;

public class Main {
    public static void main(String[] args) {
        User artem = User.of("Artem", 43);

        Car car = new Car.Builder().setEngineVolume(1).setHorsePower(2).setModel("OPEL").build();

    }
}
