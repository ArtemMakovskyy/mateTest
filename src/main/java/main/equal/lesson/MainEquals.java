package main.equal.lesson;

public class MainEquals {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(5,5,"red");
        Rectangle rectangle2 = new Rectangle(5,5,"red");

        System.out.println(rectangle1.equals(rectangle2));
    }
}
