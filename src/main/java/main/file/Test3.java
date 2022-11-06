package main.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class Test3 {
    public static void main(String[] args) {
        String[] users = new String[]{"Bob", "Alice", "John",};
        File file = new File("users.txt");
        String spase = ", ";
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't write ", e);
        }

        for (String user : users) {
            try {
                user = user + ", ";
                Files.write(file.toPath(), user.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }

    }
}
