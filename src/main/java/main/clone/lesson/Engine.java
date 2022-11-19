package main.clone.lesson;

public class Engine implements Cloneable {
    private int cilinderQuantity;
    private int weight;
    private int height;
    private int horsePower;
    private int year;

    public Engine() { //please don't remove this constructor!
    }

    public Engine(int cilinderQuantity, int weight, int height, int horsePower, int year) {
        this.cilinderQuantity = cilinderQuantity;
        this.weight = weight;
        this.height = height;
        this.horsePower = horsePower;
        this.year = year;
    }

    public int getCilinderQuantity() {
        return cilinderQuantity;
    }

    public void setCilinderQuantity(int cilinderQuantity) {
        this.cilinderQuantity = cilinderQuantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "cilinderQuantity=" + cilinderQuantity +
                ", weight=" + weight +
                ", height=" + height +
                ", horsePower=" + horsePower +
                ", year=" + year +
                '}';
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("can't clone engine class", e);
        }
    }
}