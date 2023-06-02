package main.pattern.singleton;

public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;
    //#1. – Нужно добавить в класс приватное статическое поле, содержащее одиночный объект:

    private LazyInitializedSingleton() {
    }//#2 приватный конструктор, чтоб нельзя было создать новый объект

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }//#3. – Объявить статический создающий метод, который будет
    // использоваться для получения одиночки:
}
