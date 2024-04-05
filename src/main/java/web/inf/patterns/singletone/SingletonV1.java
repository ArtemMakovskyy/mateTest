package web.inf.patterns.singletone;

public class SingletonV1 {

    private static SingletonV1 singletonV1;
    private SingletonV1() {
    }

    public static SingletonV1 getSingleton() {
        if (singletonV1 == null){
            return new SingletonV1();
        }
        return singletonV1;
    }
}
