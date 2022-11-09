package main.exception.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test6ReadByLine {
    public static void main(String[] args) {
        File file = new File("cars.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
//            System.out.println((char) reader.read());
//            System.out.println(reader.readLine());
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
//                System.out.println(value);
                value = reader.readLine();
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            throw new RuntimeException(" Cant read", e);
        } finally {
        }
    }
}
