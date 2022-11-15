package main.file.home;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadWithBytes {
    public void printBytesFromFile(String fileName){
        File file = new File(fileName);
        try {
            FileReader fileReader = new FileReader(fileName);
            int readByte = fileReader.read();
            while (readByte != -1) {
                System.out.println(readByte);
                readByte = fileReader.read();
            }

        } catch (IOException e) {
            throw new RuntimeException("Cant find file: " + fileName);
        }
    }
}
