package web.inf.patterns.singletone;

public class MainStorage {
    public static void main(String[] args) {
        SingletonListStorage storage = SingletonListStorage.getInstance();
        storage.getStorage().add("storage1_1");
        storage.getStorage().add("storage1_2");
        storage.getStorage().add("storage1_3");
        storage.getStorage().add("storage1_4");

        SingletonListStorage storage2 = SingletonListStorage.getInstance();
        storage2.getStorage().add("storage2_1");
        storage2.getStorage().add("storage2_2");
        storage2.getStorage().add("storage2_3");
        storage2.getStorage().add("storage2_4");

        SingletonListStorage storage3 = SingletonListStorage.getInstance();
        System.out.println(storage3.getStorage());
    }
}
