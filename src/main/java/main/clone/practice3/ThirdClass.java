package main.clone.practice3;

public class ThirdClass {
    private FirstClass firstClass;
    private SecondClass secondClass;
    private int i;

    public ThirdClass(FirstClass firstClass, SecondClass secondClass, int i) {
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
    public ThirdClass clone()  {
        ThirdClass thirdClass = null;
        try {
            thirdClass = (ThirdClass) super.clone();
            thirdClass.setFirstClass(firstClass.clone());
            thirdClass.setSecondClass(secondClass.clone());
            return thirdClass;
        } catch (CloneNotSupportedException e) {
           throw new RuntimeException(" ");
        }

    }
}
