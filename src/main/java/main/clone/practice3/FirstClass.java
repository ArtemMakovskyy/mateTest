package main.clone.practice3;

public class FirstClass implements Cloneable{
    int i,s;

    public FirstClass() {
    }

    public FirstClass(int i, int s) {
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
    protected FirstClass clone() {
        try {
            return (FirstClass) super.clone();
        } catch (CloneNotSupportedException e) {
           throw new RuntimeException("Can't clone FirstClass.class ");
        }
    }
}
