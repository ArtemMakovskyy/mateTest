package main.collection.pecs;

public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void say(){
        System.out.println(name + " hello!");
    }
}
