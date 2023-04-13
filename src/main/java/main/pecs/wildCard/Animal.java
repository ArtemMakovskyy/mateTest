package main.pecs.wildCard;

public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void say(){
        System.out.println(name + " hello!");
    }

    @Override
    public String toString() {
        return  "name='" + name + " hello " ;
    }
}
