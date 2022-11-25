package main.clone.practice2;

import com.sun.nio.sctp.AbstractNotificationHandler;

import java.util.Objects;

public class AnimalKind implements Cloneable{
    String animalKind;
    int spanLife;

    public AnimalKind() {
    }

    public AnimalKind(String animalKind, int spanLife) {
        this.animalKind = animalKind;
        this.spanLife = spanLife;
    }

    public String getAnimalKind() {
        return animalKind;
    }

    public void setAnimalKind(String animalKind) {
        this.animalKind = animalKind;
    }

    public int getSpanLife() {
        return spanLife;
    }

    public void setSpanLife(int spanLife) {
        this.spanLife = spanLife;
    }

    @Override
    public String toString() {
        return "AnimalKind{" +
                "animalKind='" + animalKind + '\'' +
                ", spanLife=" + spanLife +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            System.out.println("1 Reflaction");
            return true;
        }
        if (o == null) {
            System.out.println("2 Null check");
            return false;
        }
        System.out.println("3 Symetric a=b true b=a");
        System.out.println("4 Transitive a=b & b=c true c=a");
        System.out.println("5 Consistent multiple invocations must return the same");

        if (o.getClass().equals(AnimalKind.class)) {
            return this.animalKind.equals(((AnimalKind) o).animalKind)
                    && this.spanLife == ((AnimalKind) o).spanLife;
        }
        return false;
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AnimalKind that = (AnimalKind) o;
//        return spanLife == that.spanLife && Objects.equals(animalKind, that.animalKind);
    }

    @Override
    public int hashCode() {
        System.out.println("1. if two objects are equal, they mast have the same hash code.");
        System.out.println("2. if two objects have the same code. They may or may not be equals");
        System.out.println("3. if two objects have the different hash code they must be not equals");
        System.out.println("4. The same objects must returned the same code until the changed");
        int result = 17;
        result = result * 31 + (animalKind == null ? 0 : animalKind.hashCode());
        result = result * 31 + (spanLife);
        return result;

//        return Objects.hash(animalKind, spanLife);
    }

    @Override
    protected AnimalKind clone()  {
        try {
            return (AnimalKind) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
