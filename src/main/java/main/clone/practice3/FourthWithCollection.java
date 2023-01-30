package main.clone.practice3;

import main.immutable.Info;

import java.util.List;

public class FourthWithCollection implements Cloneable{
   private String string;
   private List<Integer> integerList;

    public FourthWithCollection() {
    }

    public FourthWithCollection(String string, List<Integer> integerList) {
        this.string = string;
        this.integerList = integerList;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }

    @Override
    public String toString() {
        return "FourthWithCollection{" +
                "string='" + string + '\'' +
                ", integerList=" + integerList +
                '}';
    }

    @Override
    protected FourthWithCollection clone()  {
        try {
            FourthWithCollection fourthWithCollection = (FourthWithCollection) super.clone();
            fourthWithCollection.setIntegerList(integerList);
            return fourthWithCollection;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cant't clone FourthWithCollection");
        }
    }
}
