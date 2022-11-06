package main.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test8Absolute_and_relativePath {
    public static void main(String[] args) {
//        createFile();
//        showPaths();
//        showPaths2();
        Path parentDire = Paths.get("./src/main/java/main/file/../exception");
        listForFolder(parentDire.toFile());
        Path parentDire2 = Paths.get("./src/main/java/main");
        listForFolder(parentDire2.toFile());
    }

    public static void listForFolder(File folder) {
        for (File fileEntry : folder.listFiles()){
            System.out.println("Is dir: " + fileEntry.isDirectory()
            + ", file name: " + fileEntry.getName());
        }
    }

    public static void createFile() {
        String path = "src/main/java/main/file/testFile.txt";
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't write ", e);
        }
    }

    public static void showPaths() {
        File file = new File("users.txt");
        System.out.println(file.exists());
        System.out.println(file.getPath());
        System.out.println(file.getAbsoluteFile());
        System.out.println("------");
        Path parentDir = Paths.get(".");
        Path parentDir2 = Paths.get("main/file");
        System.out.println(parentDir2.toAbsolutePath().toString());
        System.out.println(parentDir2);
    }

    public static void showPaths2() {

        Path parentDirectory4 = Paths.get("./src/main/java/main/file/../exception");
        System.out.println(parentDirectory4.toAbsolutePath() + " \n");
        System.out.println(parentDirectory4);
    }
}
