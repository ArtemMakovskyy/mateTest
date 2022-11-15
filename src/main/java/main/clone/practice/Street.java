package main.clone.practice;

public class Street implements Cloneable{
    private String nameStreet;
    private int buildingNumber;

    public Street(String nameStreet, int buildingNumber) {
        this.nameStreet = nameStreet;
        this.buildingNumber = buildingNumber;
    }

    public String getNameStreet() {
        return nameStreet;
    }

    public void setNameStreet(String nameStreet) {
        this.nameStreet = nameStreet;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    @Override
    public Street clone()  {
        try {
            return (Street) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Street{" +
                "nameStreet='" + nameStreet + '\'' +
                ", buildingNumber=" + buildingNumber +
                '}';
    }
}

