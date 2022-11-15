package main.file.home;

public class Main {
    public static void main(String[] args) {
        byte[]b = {25,36,45,75,11,0};
        WorkWithBytes wb = new WorkWithBytes();
        wb.writeBytesToFile("writeByte2.txt",b);
        ReadWithBytes readWithBytes = new ReadWithBytes();
        readWithBytes.printBytesFromFile("writeByte2.txt");
    }
}
