package main.lambda.tasks;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        GetRandomColor getRandomColor = new GetRandomColor();
        System.out.println(getRandomColor.get());
    }
}
