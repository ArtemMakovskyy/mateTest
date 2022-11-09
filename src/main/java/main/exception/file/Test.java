package main.exception.file;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        File file_myTxt1 = new File("myTxt1.txt");

        File folder = new File("myTestFolder");
        folder.mkdir();

        String filePath = "myTestFolder" + File.separator + "myTxt2.txt";
        File file_myTxt2 = new File(filePath);
        try {
            file_myTxt1.createNewFile();
            file_myTxt2.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("can't wright", e);
        }
    }
}
