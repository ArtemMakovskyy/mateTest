package work.task;

public class MemoryTestTask {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        long maxMemory = runtime.maxMemory();       // Максимальный размер heap (-Xmx)
        long allocatedMemory = runtime.totalMemory(); // Выделенная JVM память
        long freeMemory = runtime.freeMemory();     // Свободная память внутри JVM

        System.out.println("Максимальный heap (Xmx): " + (maxMemory / 1024 / 1024) + " MB");
        System.out.println("Выделено сейчас: " + (allocatedMemory / 1024 / 1024) + " MB");
        System.out.println("Свободно в heap: " + (freeMemory / 1024 / 1024) + " MB");

        // Заполним память для теста
        double[] memoryArray = new double[500_000_000]; // Около 4 ГБ

        System.out.println("После выделения:");
        System.out.println("Выделено сейчас: " + (runtime.totalMemory() / 1024 / 1024) + " MB");
        System.out.println("Свободно в heap: " + (runtime.freeMemory() / 1024 / 1024) + " MB");
    }
}