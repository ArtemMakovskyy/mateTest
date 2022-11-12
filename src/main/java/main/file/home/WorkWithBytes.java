package main.file.home;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WorkWithBytes {
    public void writeBytesToFile(String fileName, byte[] data) {
//        File file = new File(fileName);
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))){
//            file.createNewFile();
//            for (byte b : data) {
//                bufferedWriter.write(b );
//            }
//        } catch (IOException e) {
//            throw new RuntimeException("Can't write data to file " + fileName, e);
//        }
        File file = new File(fileName);
        try (FileWriter fw = new FileWriter(new File(fileName))) {
            file.createNewFile();
            for (byte b : data) {
                fw.write(b);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName, e);
        }
    }
}
