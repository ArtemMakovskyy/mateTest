package multithreading._2.synchronization.race.condition;

public class Counter {
    private int value;
    public void incrementValue(){
        System.out.println(
                String.format("%s increment value from %d",
                        Thread.currentThread().getName(),value));
        value++;
        System.out.println(
                String.format("%s increment value from %d",
                        Thread.currentThread().getName(),value));
    }

    public int getValue() {
        return value;
    }
}
