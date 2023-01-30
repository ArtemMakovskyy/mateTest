package main.immutable.finalfields;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public final class Address implements Cloneable{
    private  String street;
    private  int house;

    public Address(String street, int house) {
        this.street = street;
        this.house = house;
    }
    @Override
    protected Address clone()  {
        try {
            return (Address)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone Address, " + e);
        }
    }
}