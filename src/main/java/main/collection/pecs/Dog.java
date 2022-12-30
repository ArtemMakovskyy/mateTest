package main.collection.pecs;

public class Dog extends Animal{
    public Dog(String name, int age, int price) {
        super(name, age, price);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", price=" + price +
                '}';
    }
}
