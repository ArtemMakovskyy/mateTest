package main.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test4_BW_flash {
    public static void main(String[] args) {
        String[] users = new String[]{"Bob", "Alice", "John",};
        File file = new File("users.txt");

            BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                for (String user : users) {
                    bufferedWriter.write(user);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            }catch (IOException e){
                throw new RuntimeException("Can't write ", e);
            } finally {
                if (bufferedWriter != null){
                    try {
                        bufferedWriter.close();
                    } catch (IOException e) {
                        throw new RuntimeException("Can't close ", e);
                    }
                }
            }
    }
}
