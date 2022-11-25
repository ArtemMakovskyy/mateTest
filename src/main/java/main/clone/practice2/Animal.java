package main.clone.practice2;

import java.util.Objects;

public class Animal implements Cloneable {
    private AnimalKind animalKind;
    private String name;

    public Animal() {
    }

    public Animal(AnimalKind animalKind, String name) {
        this.animalKind = animalKind;
        this.name = name;
    }

    public AnimalKind getAnimalKind() {
        return animalKind;
    }

    public void setAnimalKind(AnimalKind animalKind) {
        this.animalKind = animalKind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass().equals(Animal.class)) {
            return this.animalKind.equals(((Animal) o).animalKind)
                    && this.name.equals(((Animal) o).name);
        }
        return false;

//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Animal animal = (Animal) o;
//        return Objects.equals(animalKind, animal.animalKind) && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        int result = 13;
        result = result * 31 + (name == null ? 0 : name.hashCode());
        result = result * 31 + (animalKind == null ? 0 : animalKind.hashCode());
        return result;
//        return Objects.hash(animalKind, name);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalKind=" + animalKind +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    protected Animal clone() {
        try {
            Animal cloneAnimal = (Animal) super.clone();
            cloneAnimal.setAnimalKind(animalKind.clone());
            return cloneAnimal;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
