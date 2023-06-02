package main.pattern.singleton;

public class SingletonSecondVar {
    private SingletonSecondVar instance;

    private SingletonSecondVar() {
    }

    public SingletonSecondVar getInstance(){
        return instance != null ? instance : new SingletonSecondVar();
    }
}
