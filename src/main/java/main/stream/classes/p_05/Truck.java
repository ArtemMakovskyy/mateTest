package main.stream.classes.p_05;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Truck {
    private String model;
    private Engine engine;
    private List<Wheel> wheels;

    public Truck(String model) {
        this.model = model;
    }
}
