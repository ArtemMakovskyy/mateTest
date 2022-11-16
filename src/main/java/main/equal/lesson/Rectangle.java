package main.equal.lesson;

import java.util.Objects;

public class Rectangle {
    private Integer width;
    private Integer length;
    private String color;

    public Rectangle(Integer width, Integer length, String color) {
        this.width = width;
        this.length = length;
        this.color = color;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getLength() {
        return length;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int hashCode() {
//        Якщо тдва обїектирівні вони повинні повертати однаковий хешкод
        int result = 17;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + width;
        result = 31 * result + length;
        return result;
    }

    @Override
    public boolean equals(Object rectangle) {
//1        Reflexive
        if (rectangle == this) {
            return true;
        }
//        2 Null Check
        if (rectangle == null) {
            return false;
        }
//        Symmetry
//        Transitive
//        Consistent simple
//        if (rectangle.getClass().equals(Rectangle.class)) {
//            Rectangle current = (Rectangle) rectangle;
//            return this.width == current.width
//                    && this.length == current.length
//                    && this.color.equals(current.color);
//        }
        //        Consistent  pro
        if (rectangle.getClass().equals(Rectangle.class)) {
            Rectangle current = (Rectangle) rectangle;
            return this.width == current.width
                    && this.length == current.length
                    && Objects.equals(this.color, current.color);
        }
        return false;
//        any non-null
    }
}
