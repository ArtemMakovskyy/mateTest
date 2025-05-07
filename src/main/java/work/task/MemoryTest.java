package work.task;

public class MemoryTest {
    public static void main(String[] args) {
        int GB = 7;
        long size = (long) GB * 1024 * 1024 * 1024 / 8; // Количество элементов типа double

        System.out.println("Начало заполнения памяти...");
        long startTime = System.nanoTime();

        double[] memoryArray = new double[(int) size]; // Заполняем память
        for (int i = 0; i < memoryArray.length; i++) {
            memoryArray[i] = 1.0;
        }

        long endTime = System.nanoTime();
        System.out.println("Время заполнения " + GB + " ГБ ОЗУ: " + (endTime - startTime) / 1e9 + " секунд");
    }
}
