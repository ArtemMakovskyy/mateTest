package patterns.decorator.coffesample.service;

import lombok.Data;

@Data
public class SimpleCoffeeImpl implements Coffee {
    @Override
    public String getDescription() {
        return "Простой кофе";
    }

    @Override
    public double getCost() {
        return 50;
    }
}
