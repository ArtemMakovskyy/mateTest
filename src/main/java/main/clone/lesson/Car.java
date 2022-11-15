package main.clone.lesson;

public class Car implements Cloneable {
    private Engine engine;
    private int doorsQuantity;
    private String color;
    private String model;
    private double price;

    public Car() { //please don't remove this constructor!
    }

    public Car(Engine engine, int doorsQuantity, String color, String model, double price) {
        this.engine = engine;
        this.doorsQuantity = doorsQuantity;
        this.color = color;
        this.model = model;
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getDoorsQuantity() {
        return doorsQuantity;
    }

    public void setDoorsQuantity(int doorsQuantity) {
        this.doorsQuantity = doorsQuantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", doorsQuantity=" + doorsQuantity +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    protected Car clone() {
        try {
            Car cloneCar = (Car) super.clone();
            cloneCar.setEngine(engine.clone());
            return cloneCar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("can't clone car", e);
        }
    }
}
