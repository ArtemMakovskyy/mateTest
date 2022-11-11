package main.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) {
        String[] users = new String[]{"Bob", "Alice", "John",};
        File file = new File("users.txt");
        for (String user : users) {
            try (BufferedWriter br = new BufferedWriter(new FileWriter(new File("users.txt"),true));) {
                br.write(user + ", ");
            } catch (IOException e) {
                throw new RuntimeException("Can't write ", e);
            }
        }
    }
}
