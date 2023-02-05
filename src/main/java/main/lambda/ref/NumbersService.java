package main.lambda.ref;

public interface NumbersService<T extends Number> {
    T getFormString(String value);
}
