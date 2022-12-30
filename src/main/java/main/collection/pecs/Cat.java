package main.collection.pecs;

public class Cat extends Animal {

    public Cat(String name, int age, int price) {
        super(name, age, price);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", price=" + price +
                '}';
    }
}
