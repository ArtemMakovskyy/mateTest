package patterns.decorator.coffesample;

import patterns.decorator.coffesample.service.Coffee;
import patterns.decorator.coffesample.service.decarator.MilkDecorator;
import patterns.decorator.coffesample.service.SimpleCoffeeImpl;
import patterns.decorator.coffesample.service.decarator.SugarDecorator;

public class MainCoffee {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffeeImpl();
        System.out.println(coffee.getDescription() + " -> " + coffee.getCost() + " грн");

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " -> " + coffee.getCost() + " грн");

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " -> " + coffee.getCost() + " грн");
    }
}
