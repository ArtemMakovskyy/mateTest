package main.clone;

public class Adress {
    private String street;
    private int homeNumber;
    private int apartmentNumber;

    public Adress(String street, int homeNumber, int apartmentNumber) {
        this.street = street;
        this.homeNumber = homeNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", homeNumber=" + homeNumber +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }
}
