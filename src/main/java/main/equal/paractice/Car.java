package main.equal.paractice;

import java.util.Objects;

public class Car {
    private String model;
    private String color;
    private int price;

    @Override
    public boolean equals(Object car) {
        if (car == this) {
            return true;
        }
        if (car == null) {
            return false;
        }
        if (car.getClass().equals(Car.class)) {
            Car car1 = (Car) car;
            return this.price == car1.price && this.color.equals(car1.color) && this.model.equals(car1.model);
        }
        return false;
    }
}