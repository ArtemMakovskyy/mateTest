package main.clone.practice3;

public class SecondClass implements Cloneable {
    int i, s;

    public SecondClass() {
    }

    public SecondClass(int i, int s) {
        this.i = i;
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "FirstClass{" +
                "i=" + i +
                ", s=" + s +
                '}';
    }

    @Override
    public SecondClass clone() {
        return new SecondClass(i, s);
    }
}
