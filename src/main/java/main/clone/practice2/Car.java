package main.clone.practice2;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {
    private Wheel wheel;
    private String color;
    private int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price && Objects.equals(wheel, car.wheel) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wheel, color, price);
    }

    @Override
    protected Car clone() throws CloneNotSupportedException {
        return new Car(wheel.clone(),color,price);
    }
}
