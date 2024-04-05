package web.inf.patterns.singletone;

import java.util.ArrayList;
import java.util.List;

public class SingletonListStorage {
    private static SingletonListStorage instance;
    private List<String> storage;

    private SingletonListStorage() {
        storage = new ArrayList<>();
    }

    public static SingletonListStorage getInstance() {
        if (instance == null) {
            instance = new SingletonListStorage();
        }
        return instance;
    }

    public List<String> getStorage() {
        return storage;
    }
}