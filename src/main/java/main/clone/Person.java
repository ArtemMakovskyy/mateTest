package main.clone;

public class Person {
    private Name name;
    private Adress adress;

    public Person(Name name, Adress adress) {
        this.name = name;
        this.adress = adress;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", adress=" + adress +
                '}';
    }
}
