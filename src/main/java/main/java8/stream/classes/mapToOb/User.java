package main.java8.stream.classes.mapToOb;

import lombok.Getter;

@Getter
public class User {
    String id = "id";
    String data;

    public User(String data) {
        this.data = data;
    }
}
