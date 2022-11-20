package main.pattern.of;

public class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public People of(String name, int age) {
        return new People(name, age);
    }
}
