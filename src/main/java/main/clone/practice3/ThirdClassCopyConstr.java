package main.clone.practice3;

public class ThirdClassCopyConstr {
    private FirstClass firstClass;
    private SecondClass secondClass;
    private int i;

    public ThirdClassCopyConstr(FirstClass firstClass, SecondClass secondClass, int i) {
        this.firstClass = firstClass;
        this.secondClass = secondClass;
        this.i = i;
    }

    public FirstClass getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(FirstClass firstClass) {
        this.firstClass = firstClass;
    }

    public SecondClass getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(SecondClass secondClass) {
        this.secondClass = secondClass;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public ThirdClassCopyConstr clone() {
        return new ThirdClassCopyConstr(firstClass.clone(), secondClass.clone(), i);
    }
}
