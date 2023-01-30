package main.immutable.practice;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public final class Address implements Cloneable{
    private String city;
    private String street;
    private int houseNumber;

    public Address(String city, String street, int houseNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    @Override
    protected Address clone()  {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
           throw new RuntimeException("Clone Address, " + e);
        }
    }
}
