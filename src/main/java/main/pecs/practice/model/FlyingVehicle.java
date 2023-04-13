package main.pecs.practice.model;

import lombok.*;


@Setter
@Getter
@EqualsAndHashCode
public class FlyingVehicle {
    public FlyingVehicle() {
    }

    public FlyingVehicle(String type, String model, int speed, int passengersQuantity) {
        this.type = type;
        this.model = model;
        this.speed = speed;
        this.passengersQuantity = passengersQuantity;
    }

    private String type;
    private String model;
    private int speed;
    private int passengersQuantity;

    public String showTechnicalDescription() {
        return type + " " + model + ", max speed: " + speed + ", passengers " + passengersQuantity + ".";
    }
}
