package main.lambda.tasks;

import java.util.Random;
import java.util.function.Supplier;

public class GetRandomColor2 {
    private static final String[] COLORS = {"red", "green", "blue", "yellow", "pink",
            "black", "white"};

    Supplier<String> getRandomColor = new Supplier<String>() {
        @Override
        public String get() {
            int colorIndex = new Random().nextInt(COLORS.length);
            System.out.println(colorIndex);
            return COLORS[colorIndex];
        }
    };
    public String actualColor = getRandomColor.get();
}