package main.SOLID._03_LSP_2.model;

public class Parrot implements FlyingBird{
    @Override
    public void dance() {
        System.out.println("Parrot dancing");
    }

    @Override
    public void fly() {
        System.out.println("Parrot is flying");
    }
}
