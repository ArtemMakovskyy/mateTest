package main.java8.optional._01;

import lombok.*;

import java.util.function.Consumer;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Wrapper<T> {
    private T value;

    public Wrapper(T value) {
        this.value = value;
    }

    public static Wrapper empty() {
        return new Wrapper<>(null);
    }
    public boolean isPresent(){
        return value != null;
    }

    public void ifPresent(Consumer<T> consumer) {
        if (value != null)
        consumer.accept(value);
    }
}
