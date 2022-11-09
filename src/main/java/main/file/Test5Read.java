package main.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test5Read {
    public static void main(String[] args) {
        File file = new File("cars.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
//            System.out.println((char) reader.read());
//            System.out.println(reader.readLine());
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            throw new RuntimeException(" Cant read", e);
        } finally {
        }
    }
}
