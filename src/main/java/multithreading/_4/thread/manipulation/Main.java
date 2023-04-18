package multithreading._4.thread.manipulation;

public class Main {
    public static void main(String... args) {
        String finalPackage = "-";
        String[] packages = new String[]{"A", "B", "C", "D", finalPackage};
        DataService ds = new DataService();

        Thread producer = new Thread(new DataProducer(ds, packages));
        Thread consumer = new Thread(new DataConsumer(ds, finalPackage));
//        producer.start();
//        consumer.start();
    }
}
