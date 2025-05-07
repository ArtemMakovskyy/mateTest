package patterns.decorator.coffesample.service.decarator;

import patterns.decorator.coffesample.service.Coffee;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", с молоком";
    }

    @Override
    public double getCost() {
        return super.getCost() + 10;
    }
}
