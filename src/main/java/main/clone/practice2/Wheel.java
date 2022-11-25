package main.clone.practice2;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Wheel implements Cloneable{
    private String typeWheel;
    private String color;
    private int size;
    private int price;

    @Override
    public int hashCode() {
        int rezult = 13;
        rezult = 31 * rezult + (typeWheel == null ? 0 : typeWheel.hashCode());
        rezult = 31 * rezult + (color == null ? 0 : color.hashCode());
        rezult = 31 * rezult + size;
        rezult = 31 * rezult + price;
        return rezult;
    }

    @Override
    public boolean equals(Object wheel) {
        if (wheel == this || wheel != null) {
            return true;
        }
        if (wheel.getClass().equals(Wheel.class)) {
            return this.price == ((Wheel) wheel).price
                    && this.size == ((Wheel) wheel).size
                    && this.color.equals(((Wheel) wheel).color)
                    && Objects.equals(this.typeWheel, ((Wheel) wheel).typeWheel);
        }
        return false;
    }

    @Override
    protected Wheel clone() {
        try {
            return (Wheel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("wheel can't clone ", e);
        }
    }
}
