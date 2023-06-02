package main.practice.Inharitance;

import java.util.Objects;

public class People {
    private String name;
    private String serName;
    private String age;

    public People(String name, String serName, String age) {
        this.name = name;
        this.serName = serName;
        this.age = age;
    }

    public People() {
    }
    public static void show(){
        System.out.println("i shiw you");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", serName='" + serName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof People)) return false;
        People people = (People) o;
        return Objects.equals(getName(), people.getName()) && Objects.equals(getSerName(), people.getSerName()) && Objects.equals(getAge(), people.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSerName(), getAge());
    }
}
