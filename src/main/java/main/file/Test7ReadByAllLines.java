package main.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Test7ReadByAllLines {
    public static void main(String[] args) {
        File file = new File("cars.txt");
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            System.out.println(strings);
        } catch (IOException e) {
            throw new RuntimeException("sdfsdf", e);
        }

    }
}
